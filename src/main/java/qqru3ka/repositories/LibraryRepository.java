package qqru3ka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.entities.UserLibrary;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<UserLibrary, Integer> {
    UserLibrary findByUserAndGame(User user, Game game);
    List<UserLibrary> findByUser(User user);
    Boolean existsByUserAndGame(User user, Game game);
}
