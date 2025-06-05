package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import qqru3ka.entities.*;
import qqru3ka.repositories.GameRepository;
import qqru3ka.repositories.UserRepository;
import qqru3ka.repositories.WishlistRepository;

import java.util.List;

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
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Game game = gameRepository.findById(gameId).orElseThrow(EntityNotFoundException::new);

        if (wishlistRepository.existsByUserAndGame(user, game)) {
            throw new IllegalStateException();
        }

        UserWishlist entry = new UserWishlist(user, game);
        return wishlistRepository.save(entry);
    }

    @Transactional
    public void removeFromWishlist(Integer userId, Integer gameId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Game game = gameRepository.findById(gameId).orElseThrow(EntityNotFoundException::new);

        UserWishlist entry = wishlistRepository.findByUserAndGame(user, game);
        wishlistRepository.delete(entry);
    }

    public List<UserWishlist> findGamesInWishlist(Integer id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return wishlistRepository.findByUser(user);
    }
}
