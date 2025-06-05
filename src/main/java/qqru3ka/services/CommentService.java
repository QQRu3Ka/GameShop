package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import qqru3ka.dto.CommentDto;
import qqru3ka.entities.Comment;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.repositories.CommentRepository;
import qqru3ka.repositories.GameRepository;
import qqru3ka.repositories.UserRepository;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, GameRepository gameRepository,
                          UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    public List<Comment> findByGameId(Integer id) {
        Game game = gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return commentRepository.findByGame(game);
    }

    @Transactional
    public Comment storeComment(CommentDto commentDto) {
        User user = userRepository.findById(commentDto.getUserId()).orElseThrow(EntityNotFoundException::new);
        Game game = gameRepository.findById(commentDto.getGameId()).orElseThrow(EntityNotFoundException::new);
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setGame(game);
        comment.setRating(commentDto.getRating());
        comment.setCommentText(commentDto.getText());
        return commentRepository.save(comment);
    }

    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }
}
