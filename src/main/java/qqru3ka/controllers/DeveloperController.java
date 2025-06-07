package qqru3ka.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qqru3ka.dto.DeveloperDto;
import qqru3ka.dto.GameAddDto;
import qqru3ka.entities.Developer;
import qqru3ka.entities.Game;
import qqru3ka.entities.User;
import qqru3ka.services.DeveloperService;
import qqru3ka.services.GameService;
import qqru3ka.services.UserService;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/dev")
public class DeveloperController {
    private final DeveloperService developerService;
    private final GameService gameService;
    private final UserService userService;

    public DeveloperController(DeveloperService developerService, GameService gameService,
                               UserService userService) {
        this.developerService = developerService;
        this.gameService = gameService;
        this.userService = userService;
    }

    @GetMapping("/dev/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        try {
            Developer developer = developerService.findById(id);
            return ResponseEntity.ok(developer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable("id") Integer id) {
        try {
            Developer developer = developerService.findByUserId(id);
            return ResponseEntity.ok(developer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> storeDeveloper(@RequestBody DeveloperDto developerDto) {
        try {
            Developer developer = developerService.storeDeveloper(developerDto);
            User user = userService.findById(developerDto.getUserId());
            userService.updateUserRole(user, "developer");
            return ResponseEntity.ok(developer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/game")
    public ResponseEntity<?> storeGame(@RequestBody GameAddDto gameAddDto) {
        try {
            Game game = gameService.storeGame(gameAddDto);
            return ResponseEntity.ok(game);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
