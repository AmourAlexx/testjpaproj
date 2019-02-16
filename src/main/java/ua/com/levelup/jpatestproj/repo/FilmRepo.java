package ua.com.levelup.jpatestproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import ua.com.levelup.jpatestproj.model.Film;
import ua.com.levelup.jpatestproj.model.Language;

import java.util.List;

@Repository
public interface FilmRepo extends JpaRepository<Film,Long> {

    /**
     * Примеры возможного нейминга
     * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
     * @param ry
     * @param l
     * @return
     */
    List<Film> findByReleaseYearAndLanguageOrderByTitle(Integer ry, Language l);

    /**
     * Имя метода не важно, только то что в @Query. Параметры по порядку
     * @param rc
     * @param rr
     * @return
     */
    @Query("from Film f where f.rentalRate = ?1 and f.replacementCost = ?2")
    List<Film> paramByOrder(double rc, double rr);

    /**
     * Параметры запроса через имена
     * @param rc
     * @param rr
     * @return
     */
    @Query("from Film f where f.rentalRate = :rentRate and f.replacementCost = :repCost")
    List<Film> withParam(@Param("repCost") double rc, @Param("rentRate") double rr);

}
