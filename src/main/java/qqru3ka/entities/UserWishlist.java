package qqru3ka.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity(name = "UserWishlist")
public class UserWishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlist_id")
    private Integer wishlistId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @Column(name = "added_date")
    private OffsetDateTime addedDate = OffsetDateTime.now();

    public UserWishlist() {
    }

    public UserWishlist(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
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

    public OffsetDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(OffsetDateTime addedDate) {
        this.addedDate = addedDate;
    }
}
