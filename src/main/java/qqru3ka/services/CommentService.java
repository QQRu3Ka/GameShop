package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import qqru3ka.entities.Comment;
import qqru3ka.entities.Game;
import qqru3ka.repositories.CommentRepository;
import qqru3ka.repositories.GameRepository;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final GameRepository gameRepository;

    public CommentService(CommentRepository commentRepository, GameRepository gameRepository) {
        this.commentRepository = commentRepository;
        this.gameRepository = gameRepository;
    }

    public List<Comment> findByGameId(Integer id) {
        Game game = gameRepository.findByGameId(id);
        if (game == null) throw new EntityNotFoundException();
        return commentRepository.findByGame(game);
    }
}
