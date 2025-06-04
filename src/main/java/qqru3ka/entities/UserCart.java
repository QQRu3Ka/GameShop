package qqru3ka.entities;

import jakarta.persistence.Entity;

import java.time.OffsetDateTime;

@Entity(name = "UserCart")
public class UserCart {
    private Integer cart_id;
    private User user;
    private Game game;
    private OffsetDateTime added_at = OffsetDateTime.now();
    private OffsetDateTime expires_at = OffsetDateTime.now().plusMinutes(10);

    public UserCart() {
    }

    public UserCart(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
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

    public OffsetDateTime getAdded_at() {
        return added_at;
    }

    public void setAdded_at(OffsetDateTime added_at) {
        this.added_at = added_at;
    }

    public OffsetDateTime getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(OffsetDateTime expires_at) {
        this.expires_at = expires_at;
    }
}
