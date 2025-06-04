package qqru3ka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qqru3ka.entities.Game;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Game findByGameId(Integer gameId);
    List<Game> findByTitleContainingIgnoreCase(String title);
    List<Game> findByDeveloperId(Integer developerId);
    List<Game> findByPriceBetween(Integer minPrice, Integer maxPrice);
    List<Game> findByRatingGreaterThanEqual(Double minRating);
    List<Game> findByGenres_Genre_GenreId(Integer genreId);
    List<Game> findByInLibraries_User_UserId(Integer userId);
    List<Game> findByInCarts_User_UserId(Integer userId);
    List<Game> findByInWishlists_User_UserId(Integer userId);
}
