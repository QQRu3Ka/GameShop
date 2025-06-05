package qqru3ka.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qqru3ka.dto.UserAuthDto;
import qqru3ka.dto.UserLoginDto;
import qqru3ka.entities.User;
import qqru3ka.entities.UserCart;
import qqru3ka.entities.UserLibrary;
import qqru3ka.entities.UserWishlist;
import qqru3ka.services.CartService;
import qqru3ka.services.LibraryService;
import qqru3ka.services.UserService;
import qqru3ka.services.WishlistService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final CartService cartService;
    private final LibraryService libraryService;
    private final WishlistService wishlistService;

    public UserController(UserService userService, CartService cartService, LibraryService libraryService,
                          WishlistService wishlistService) {
        this.userService = userService;
        this.cartService = cartService;
        this.libraryService = libraryService;
        this.wishlistService = wishlistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        try {
            User user = userService.findById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> storeUser(@RequestBody UserAuthDto userAuthDto) {
        try{
            User user = userService.storeUser(userAuthDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
        try {
            User user = userService.isExists(userLoginDto);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/updateNick/{id}")
    public ResponseEntity<?> updateNick(@PathVariable("id") Integer id,
                                        @RequestBody Map<String, String> req) {
        try {
            User user = userService.findById(id);
            String nick = req.get("nick");
            userService.updateUserNick(user, nick);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/updateRole/{id}")
    public ResponseEntity<?> updateRole(@PathVariable("id") Integer id,
                                        @RequestBody Map<String, String> req) {
        try {
            User user = userService.findById(id);
            String role = req.get("role");
            userService.updateUserRole(user, role);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/updateBalance/{id}")
    public ResponseEntity<?> updateBalance(@PathVariable("id") Integer id,
                                           @RequestBody Map<String, Integer> req) {
        try {
            User user = userService.findById(id);
            Integer balance = req.get("balance");
            userService.updateUserBalance(user, balance);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/updateInfo/{id}")
    public ResponseEntity<?> updateInfo(@PathVariable("id") Integer id,
                                        @RequestBody Map<String, String> req) {
        try {
            User user = userService.findById(id);
            String info = req.get("info");
            userService.updateUserInfo(user, info);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{id}/cart")
    public ResponseEntity<?> addToCart(@PathVariable("id") Integer id,
                                       @RequestBody Map<String, Integer> req) {
        try {
            UserCart userCart = cartService.addToCart(id, req.get("game_id"));
            return ResponseEntity.ok(userCart);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/cart")
    public ResponseEntity<?> removeFromCart(@PathVariable("id") Integer id,
                                       @RequestBody Map<String, Integer> req) {
        try {
            cartService.removeFromCart(id, req.get("game_id"));
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/cart")
    public ResponseEntity<?> showCart(@PathVariable("id") Integer id) {
        try {
            List<UserCart> userCart = cartService.findGamesInCart(id);
            return ResponseEntity.ok(userCart);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{id}/library")
    public ResponseEntity<?> addToLibrary(@PathVariable("id") Integer id,
                                       @RequestBody Map<String, Integer> req) {
        try {
            UserLibrary userLibrary = libraryService.addToLibrary(id, req.get("game_id"));
            return ResponseEntity.ok(userLibrary);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/library")
    public ResponseEntity<?> removeFromLibrary(@PathVariable("id") Integer id,
                                            @RequestBody Map<String, Integer> req) {
        try {
            libraryService.removeFromLibrary(id, req.get("game_id"));
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/library")
    public ResponseEntity<?> showLibrary(@PathVariable("id") Integer id) {
        try {
            List<UserLibrary> userLibrary = libraryService.findGamesInLibrary(id);
            return ResponseEntity.ok(userLibrary);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{id}/wishlist")
    public ResponseEntity<?> addToWishlist(@PathVariable("id") Integer id,
                                          @RequestBody Map<String, Integer> req) {
        try {
            UserWishlist userWishlist = wishlistService.addToWishlist(id, req.get("game_id"));
            return ResponseEntity.ok(userWishlist);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/wishlist")
    public ResponseEntity<?> removeFromWishlist(@PathVariable("id") Integer id,
                                               @RequestBody Map<String, Integer> req) {
        try {
            wishlistService.removeFromWishlist(id, req.get("game_id"));
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/wishlist")
    public ResponseEntity<?> showWishlist(@PathVariable("id") Integer id) {
        try {
            List<UserWishlist> userWishlist = wishlistService.findGamesInWishlist(id);
            return ResponseEntity.ok(userWishlist);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
