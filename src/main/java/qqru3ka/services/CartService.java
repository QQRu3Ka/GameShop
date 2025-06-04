package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.entities.UserCart;
import qqru3ka.entities.UserWishlist;
import qqru3ka.repositories.CartRepository;
import qqru3ka.repositories.GameRepository;
import qqru3ka.repositories.UserRepository;

@Service
public class CartService {
    private CartRepository cartRepository;
    private UserRepository userRepository;
    private GameRepository gameRepository;

    public CartService(CartRepository cartRepository, UserRepository userRepository,
                       GameRepository gameRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public UserCart addToCart(Integer userId, Integer gameId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) throw new EntityNotFoundException();
        Game game = gameRepository.findByGameId(gameId);
        if (game == null) throw new EntityNotFoundException();

        if (cartRepository.existsByUserAndGame(user, game)) {
            throw new IllegalStateException();
        }

        UserCart entry = new UserCart(user, game);
        return cartRepository.save(entry);
    }

    @Transactional
    public void removeFromCart(Integer userId, Integer gameId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) throw new EntityNotFoundException();
        Game game = gameRepository.findByGameId(gameId);
        if (game == null) throw new EntityNotFoundException();

        UserCart entry = cartRepository.findByUserAndGame(user, game);
        cartRepository.delete(entry);
    }
}
