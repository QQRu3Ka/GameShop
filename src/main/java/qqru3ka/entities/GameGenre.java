package qqru3ka.entities;

import jakarta.persistence.*;

@Entity(name = "GameGenres")
@IdClass(GameGenreId.class)
public class GameGenre {
    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @Id
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public GameGenre() {
    }

    public GameGenre(Game game, Genre genre) {
        this.game = game;
        this.genre = genre;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
