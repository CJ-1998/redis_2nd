package project.redis.screening.adapter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.screening.Screening;
import project.redis.screening.entity.ScreeningEntity;
import project.redis.screening.mapper.ScreeningMapper;
import project.redis.screening.repository.ScreeningRepository;

@Component
@RequiredArgsConstructor
public class ScreeningAdapter {

    private final ScreeningRepository screeningRepository;
    private final ScreeningMapper screeningMapper;

    public List<Screening> findScreeningsByMovieName(String movieName) {
        List<ScreeningEntity> screeningEntities = screeningRepository.findByMovieTitle(movieName);
        return screeningEntities.stream()
                .map(screeningMapper::toDomain)
                .toList();
    }
}
