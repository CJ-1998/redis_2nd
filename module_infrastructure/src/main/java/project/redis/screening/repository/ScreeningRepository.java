package project.redis.screening.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.redis.screening.entity.ScreeningEntity;

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningEntity, Long> {

    List<ScreeningEntity> findByMovieTitle(String title);
}
