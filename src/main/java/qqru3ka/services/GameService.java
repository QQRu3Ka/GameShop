package qqru3ka.services;

import org.springframework.stereotype.Service;
import qqru3ka.entities.Game;
import qqru3ka.repositories.GameRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findByTitle(String title) {
        return gameRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Game> findByDeveloperId(Integer id) {
        return gameRepository.findByDeveloperId(id);
    }

    public List<Game> findByPrice(Integer price1, Integer price2) {
        if (price1 > price2) return new ArrayList<>();
        return gameRepository.findByPriceBetween(price1, price2);
    }

    public List<Game> findByRating(Double rating) {
        return gameRepository.findByRatingGreaterThanEqual(rating);
    }

    public List<Game> findByGenreId(Integer id) {
        return gameRepository.findByGenres_Genre_GenreId(id);
    }

    public List<Game> findUserLibrary(Integer id) {
        return gameRepository.findByInLibraries_User_UserId(id);
    }

    public List<Game> findUserWishlist(Integer id) {
        return gameRepository.findByInWishlists_User_UserId(id);
    }

    public List<Game> findUserCart(Integer id) {
        return gameRepository.findByInCarts_User_UserId(id);
    }
}
