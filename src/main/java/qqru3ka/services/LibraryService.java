package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.entities.UserLibrary;
import qqru3ka.repositories.GameRepository;
import qqru3ka.repositories.LibraryRepository;
import qqru3ka.repositories.UserRepository;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public LibraryService(LibraryRepository libraryRepository, UserRepository userRepository,
                          GameRepository gameRepository) {
        this.libraryRepository = libraryRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public UserLibrary addToLibrary(Integer userId, Integer gameId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) throw new EntityNotFoundException();
        Game game = gameRepository.findByGameId(gameId);
        if (game == null) throw new EntityNotFoundException();

        if (libraryRepository.existsByUserAndGame(user, game)) {
            throw new IllegalStateException();
        }

        UserLibrary entry = new UserLibrary(user, game);
        return libraryRepository.save(entry);
    }

    @Transactional
    public void removeFromLibrary(Integer userId, Integer gameId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) throw new EntityNotFoundException();
        Game game = gameRepository.findByGameId(gameId);
        if (game == null) throw new EntityNotFoundException();

        UserLibrary entry = libraryRepository.findByUserAndGame(user, game);
        libraryRepository.delete(entry);
    }
}
