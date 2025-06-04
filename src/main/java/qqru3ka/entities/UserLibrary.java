package qqru3ka.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity(name = "UserLibrary")
public class UserLibrary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @Column(name = "purchase_date")
    private OffsetDateTime purchaseDate = OffsetDateTime.now();
    @Column(name = "last_played")
    private OffsetDateTime lastPlayed;
    @Column(name = "playtime_seconds")
    private Long playtimeSeconds = 0L;
    @Column(name = "is_installed")
    private Boolean isInstalled = false;

    public UserLibrary() {
    }

    public UserLibrary(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public OffsetDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(OffsetDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public OffsetDateTime getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(OffsetDateTime lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public Long getPlaytimeSeconds() {
        return playtimeSeconds;
    }

    public void setPlaytimeSeconds(Long playtimeSeconds) {
        this.playtimeSeconds = playtimeSeconds;
    }

    public Boolean getIsInstalled() {
        return isInstalled;
    }

    public void setIsInstalled(Boolean isInstalled) {
        this.isInstalled = isInstalled;
    }
}
