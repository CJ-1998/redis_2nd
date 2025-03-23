package project.redis.screening.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import project.redis.movie.entity.MovieEntity;
import project.redis.screening.entity.ScreeningEntity;

public interface ScreeningRepository extends JpaRepository<ScreeningEntity, Long> {

    List<ScreeningEntity> findByMovie(MovieEntity movieEntity);
}
