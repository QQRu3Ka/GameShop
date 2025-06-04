package qqru3ka.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity(name = "UserCart")
public class UserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @Column(name = "added_at")
    private OffsetDateTime addedAt = OffsetDateTime.now();
    @Column(name = "expires_at")
    private OffsetDateTime expiresAt = OffsetDateTime.now().plusMinutes(10);

    public UserCart() {
    }

    public UserCart(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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

    public OffsetDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(OffsetDateTime addedAt) {
        this.addedAt = addedAt;
    }

    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
