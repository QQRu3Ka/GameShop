package qqru3ka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.entities.UserCart;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<UserCart, Integer> {
    UserCart findByUserAndGame(User user, Game game);
    List<UserCart> findByUser(User user);
    Boolean existsByUserAndGame(User user, Game game);
}
