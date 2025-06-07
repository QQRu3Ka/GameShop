package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import qqru3ka.dto.GameAddDto;
import qqru3ka.entities.Developer;
import qqru3ka.entities.Game;
import qqru3ka.entities.GameGenre;
import qqru3ka.entities.Genre;
import qqru3ka.repositories.DeveloperRepository;
import qqru3ka.repositories.GameGenreRepository;
import qqru3ka.repositories.GameRepository;
import qqru3ka.repositories.GenreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private final GameGenreRepository gameGenreRepository;
    private final GameRepository gameRepository;
    private final GenreRepository genreRepository;
    private final DeveloperRepository developerRepository;

    public GameService(GameGenreRepository gameGenreRepository, GameRepository gameRepository,
                       GenreRepository genreRepository, DeveloperRepository developerRepository) {
        this.gameGenreRepository = gameGenreRepository;
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
        this.developerRepository = developerRepository;
    }

    public Game findById(Integer id) {
        return gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
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

    public List<GameGenre> findByGenre(Integer id) {
        Genre genre = genreRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return gameGenreRepository.findByGenre(genre);
    }

    public Game updateGameActiveStatus(Integer id, Boolean status) {
        Game game = findById(id);
        game.setIsActive(status);
        gameRepository.save(game);
        return game;
    }

    public Game storeGame(GameAddDto gameAddDto) {
        Game game = new Game();
        game.setTitle(gameAddDto.getTitle());
        Developer developer = developerRepository.findByUserId(gameAddDto.getDeveloperId()).orElseThrow(EntityNotFoundException::new);
        game.setDeveloperId(developer.getDeveloperId());
        game.setPrice(gameAddDto.getPrice());
        game.setDescription(gameAddDto.getDescription());
        game.setReleaseDate(gameAddDto.getReleaseDate());
        game.setStorageName(gameAddDto.getStorageName());
        return gameRepository.save(game);
    }

//    public List<Game> findUserLibrary(Integer id) {
//        return gameRepository.findByInLibraries_User_UserId(id);
//    }
//
//    public List<Game> findUserWishlist(Integer id) {
//        return gameRepository.findByInWishlists_User_UserId(id);
//    }
//
//    public List<Game> findUserCart(Integer id) {
//        return gameRepository.findByInCarts_User_UserId(id);
//    }
}
