package ua.com.levelup.jpatestproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.levelup.jpatestproj.model.Film;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film,Long> {

    List<Film> findByTitleLikeAndRentalRate(String title, double rr);
}
