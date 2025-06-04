package qqru3ka.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity(name = "GameGenres")
@IdClass(GameGenreId.class)
public class GameGenre {
    @Id
    private Game game;
    @Id
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
