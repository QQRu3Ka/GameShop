package qqru3ka.entities;

import java.io.Serializable;
import java.util.Objects;

public class GameGenreId implements Serializable {
    private Game game;
    private Genre genre;

    public GameGenreId() {
    }

    public GameGenreId(Game game, Genre genre) {
        this.game = game;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameGenreId that = (GameGenreId) o;
        return Objects.equals(game, that.game) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, genre);
    }
}
