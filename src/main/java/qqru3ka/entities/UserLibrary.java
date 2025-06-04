package qqru3ka.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
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
    private OffsetDateTime purchase_date = OffsetDateTime.now();
    private OffsetDateTime last_played;
    private Long playtime_seconds = 0L;
    private Boolean is_installed = false;

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

    public OffsetDateTime getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(OffsetDateTime purchase_date) {
        this.purchase_date = purchase_date;
    }

    public OffsetDateTime getLast_played() {
        return last_played;
    }

    public void setLast_played(OffsetDateTime last_played) {
        this.last_played = last_played;
    }

    public Long getPlaytime_seconds() {
        return playtime_seconds;
    }

    public void setPlaytime_seconds(Long playtime_seconds) {
        this.playtime_seconds = playtime_seconds;
    }

    public Boolean getIs_installed() {
        return is_installed;
    }

    public void setIs_installed(Boolean is_installed) {
        this.is_installed = is_installed;
    }
}
