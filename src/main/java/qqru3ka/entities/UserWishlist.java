package qqru3ka.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity(name = "UserWishlist")
public class UserWishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishlist_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    private OffsetDateTime added_date = OffsetDateTime.now();

    public UserWishlist() {
    }

    public UserWishlist(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    public Integer getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(Integer wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public OffsetDateTime getAdded_date() {
        return added_date;
    }

    public void setAdded_date(OffsetDateTime added_date) {
        this.added_date = added_date;
    }
}
