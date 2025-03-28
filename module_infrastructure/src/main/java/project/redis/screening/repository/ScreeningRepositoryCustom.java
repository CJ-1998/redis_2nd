package project.redis.screening.repository;

import java.time.LocalDate;
import java.util.List;
import project.redis.movie.MovieGenre;
import project.redis.screening.dto.ScreeningResponseDto;

public interface ScreeningRepositoryCustom {
    List<ScreeningResponseDto> findNowPlayMoviesByQuery(String movieTitle, MovieGenre movieGenre, LocalDate today);
}