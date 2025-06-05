package qqru3ka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qqru3ka.entities.GameGenre;
import qqru3ka.entities.GameGenreId;
import qqru3ka.entities.Genre;

import java.util.List;

@Repository
public interface GameGenreRepository extends JpaRepository<GameGenre, GameGenreId> {
    List<GameGenre> findByGenre(Genre genre);
}
