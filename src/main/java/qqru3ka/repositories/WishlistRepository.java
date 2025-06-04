package qqru3ka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.entities.UserWishlist;

@Repository
public interface WishlistRepository extends JpaRepository<UserWishlist, Integer> {
    UserWishlist findByUserAndGame(User user, Game game);
    Boolean existsByUserAndGame(User user, Game game);
}
