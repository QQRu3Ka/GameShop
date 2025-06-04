package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.entities.UserLibrary;
import qqru3ka.entities.UserWishlist;
import qqru3ka.repositories.GameRepository;
import qqru3ka.repositories.UserRepository;
import qqru3ka.repositories.WishlistRepository;

@Service
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public WishlistService(WishlistRepository wishlistRepository, UserRepository userRepository,
                           GameRepository gameRepository) {
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public UserWishlist addToWishlist(Integer userId, Integer gameId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) throw new EntityNotFoundException();
        Game game = gameRepository.findByGameId(gameId);
        if (game == null) throw new EntityNotFoundException();

        if (wishlistRepository.existsByUserAndGame(user, game)) {
            throw new IllegalStateException();
        }

        UserWishlist entry = new UserWishlist(user, game);
        return wishlistRepository.save(entry);
    }

    @Transactional
    public void removeFromLibrary(Integer userId, Integer gameId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) throw new EntityNotFoundException();
        Game game = gameRepository.findByGameId(gameId);
        if (game == null) throw new EntityNotFoundException();

        UserWishlist entry = wishlistRepository.findByUserAndGame(user, game);
        wishlistRepository.delete(entry);
    }
}
