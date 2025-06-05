package qqru3ka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qqru3ka.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
