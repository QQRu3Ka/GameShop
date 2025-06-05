package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.entities.UserCart;
import qqru3ka.repositories.CartRepository;
import qqru3ka.repositories.GameRepository;
import qqru3ka.repositories.UserRepository;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public CartService(CartRepository cartRepository, UserRepository userRepository,
                       GameRepository gameRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public UserCart addToCart(Integer userId, Integer gameId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Game game = gameRepository.findById(gameId).orElseThrow(EntityNotFoundException::new);

        if (cartRepository.existsByUserAndGame(user, game)) {
            throw new IllegalStateException();
        }

        UserCart entry = new UserCart(user, game);
        return cartRepository.save(entry);
    }

    @Transactional
    public void removeFromCart(Integer userId, Integer gameId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Game game = gameRepository.findById(gameId).orElseThrow(EntityNotFoundException::new);

        UserCart entry = cartRepository.findByUserAndGame(user, game);
        cartRepository.delete(entry);
    }

    @Transactional
    public List<UserCart> findGamesInCart(Integer id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return cartRepository.findByUser(user);
    }
}
