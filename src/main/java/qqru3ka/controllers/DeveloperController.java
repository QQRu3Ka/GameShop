package qqru3ka.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qqru3ka.dto.DeveloperDto;
import qqru3ka.dto.GameAddDto;
import qqru3ka.entities.Developer;
import qqru3ka.entities.Game;
import qqru3ka.services.DeveloperService;
import qqru3ka.services.GameService;

@RestController
@RequestMapping("/dev")
public class DeveloperController {
    private DeveloperService developerService;
    private GameService gameService;

    public DeveloperController(DeveloperService developerService, GameService gameService) {
        this.developerService = developerService;
        this.gameService = gameService;
    }

    @GetMapping("/game/{id}")
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

    @PostMapping("/{id}")
    public ResponseEntity<?> storeDeveloper(@RequestBody DeveloperDto developerDto) {
        try {
            Developer developer = developerService.storeDeveloper(developerDto);
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
