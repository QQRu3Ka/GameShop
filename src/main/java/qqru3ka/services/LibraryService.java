package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.entities.UserCart;
import qqru3ka.entities.UserLibrary;
import qqru3ka.repositories.GameRepository;
import qqru3ka.repositories.LibraryRepository;
import qqru3ka.repositories.UserRepository;

import java.util.List;

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
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Game game = gameRepository.findById(gameId).orElseThrow(EntityNotFoundException::new);

        if (libraryRepository.existsByUserAndGame(user, game)) {
            throw new IllegalStateException();
        }

        UserLibrary entry = new UserLibrary(user, game);
        return libraryRepository.save(entry);
    }

    @Transactional
    public void removeFromLibrary(Integer userId, Integer gameId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Game game = gameRepository.findById(gameId).orElseThrow(EntityNotFoundException::new);

        UserLibrary entry = libraryRepository.findByUserAndGame(user, game);
        libraryRepository.delete(entry);
    }

    public List<UserLibrary> findGamesInLibrary(Integer id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return libraryRepository.findByUser(user);
    }
}
