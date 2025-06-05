package qqru3ka.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qqru3ka.dto.CommentDto;
import qqru3ka.dto.GameStatusDto;
import qqru3ka.entities.Comment;
import qqru3ka.entities.Game;
import qqru3ka.entities.GameGenre;
import qqru3ka.entities.User;
import qqru3ka.services.CommentService;
import qqru3ka.services.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/game")
public class GameController {
    private GameService gameService;
    private CommentService commentService;

    public GameController(GameService gameService, CommentService commentService) {
        this.gameService = gameService;
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        try {
            Game game = gameService.findById(id);
            return ResponseEntity.ok(game);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/title")
    public ResponseEntity<?> findByTitle(@RequestBody Map<String, String> req) {
        try {
            List<Game> games = gameService.findByTitle(req.get("title"));
            return ResponseEntity.ok(games);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/dev")
    public ResponseEntity<?> findByDeveloperId(@RequestBody Map<String, Integer> req) {
        try {
            List<Game> games = gameService.findByDeveloperId(req.get("developer_id"));
            return ResponseEntity.ok(games);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/price")
    public ResponseEntity<?> findByPrice(@RequestBody Map<String, Integer> req) {
        try {
            List<Game> games = gameService.findByPrice(req.get("price1"), req.get("price2"));
            return ResponseEntity.ok(games);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/rating")
    public ResponseEntity<?> findByRating(@RequestBody Map<String, Double> req) {
        try {
            List<Game> games = gameService.findByRating(req.get("rating"));
            return ResponseEntity.ok(games);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/genre")
    public ResponseEntity<?> findByGenre(@RequestBody Map<String, Integer> req) {
        try {
            List<Game> games = gameService.findByGenre(req.get("genre"))
                    .stream()
                    .map(GameGenre::getGame)
                    .toList();
            return ResponseEntity.ok(games);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/comment")
    public ResponseEntity<?> findCommentsByGameId(@PathVariable("id") Integer id) {
        try {
            List<Comment> comments = commentService.findByGameId(id);
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<?> storeComment(@PathVariable("id") Integer id,
                                          @RequestBody CommentDto commentDto) {
        try{
            Comment comment = commentService.storeComment(commentDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(comment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/status")
    public ResponseEntity<?> updateGameStatus(@RequestBody GameStatusDto gameStatusDto) {
        try {
            gameService.updateGameActiveStatus(gameStatusDto.getGameId(), gameStatusDto.getStatus());
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
