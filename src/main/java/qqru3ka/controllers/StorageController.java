package qqru3ka.controllers;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import qqru3ka.entities.Game;
import qqru3ka.services.GameService;
import qqru3ka.services.StorageService;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/storage")
public class StorageController {
    private StorageService storageService;
    private GameService gameService;

    public StorageController(StorageService storageService, GameService gameService) {
        this.storageService = storageService;
        this.gameService = gameService;
    }

    @GetMapping("/download/{gameId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("gameId") Integer id) {
        Game game = gameService.findById(id);
        Resource resource = storageService.loadAsResource(game.getStorageName());
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file")MultipartFile file) {
        storageService.store(file);
    }
}
