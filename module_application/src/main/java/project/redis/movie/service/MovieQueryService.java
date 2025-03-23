package project.redis.movie.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import project.redis.movie.MovieGenre;
import project.redis.movie.dto.NowPlayMovieDto;
import project.redis.screening.dto.ScreeningResponseDto;
import project.redis.screening.dto.ScreeningTimeDto;
import project.redis.screening.repository.ScreeningRepositoryCustom;

@Service
@RequiredArgsConstructor
public class MovieQueryService {

    private final ScreeningRepositoryCustom screeningRepository;

    @Cacheable(cacheNames = "movieCache")
    public List<NowPlayMovieDto> getNowPlayingMovies(String movieTitle, String movieGenre) {
        MovieGenre movieGenreEnum = null;

        if (movieGenre != null) {
            movieGenreEnum = MovieGenre.valueOf(movieGenre);
        }

        List<ScreeningResponseDto> moviesGroupedByTheater
                = screeningRepository.findMoviesGroupedByTheater(movieTitle, movieGenreEnum, LocalDate.now());

        Map<String, Map<String, List<ScreeningResponseDto>>> groupedByMovieAndTheater = moviesGroupedByTheater.stream()
                .collect(Collectors.groupingBy(
                        ScreeningResponseDto::getMovieTitle,  // 첫 번째 그룹: movieTitle 기준
                        Collectors.groupingBy(
                                ScreeningResponseDto::getCinemaAndTheaterName))); // 두 번째 그룹: cinemaAndTheaterName 기준

        // Flatten 리스트
        return groupedByMovieAndTheater.values().stream()
                .map(stringListMap -> {
                    // 영화의 상영 리스트를 변환
                    return stringListMap.values().stream()
                            .map(screenings -> {
                                // 영화의 각 극장 및 상영 정보

                                // ScreeningTimeDto 변환
                                List<ScreeningTimeDto> screeningTimeDtos = screenings.stream()
                                        .map(ScreeningTimeDto::createByQueryDto)
                                        .sorted(Comparator.comparing(ScreeningTimeDto::getStartTime))
                                        .collect(Collectors.toList());

                                // NowPlayMovieDto 빌더 패턴을 사용하여 DTO 생성
                                ScreeningResponseDto screeningResponseDto = screenings.get(0);
                                return NowPlayMovieDto.createByQueryDto(screeningResponseDto, screeningTimeDtos);
                            })
                            .collect(Collectors.toList());
                })
                .flatMap(List::stream)
                .sorted(Comparator.comparing(NowPlayMovieDto::getMovieReleaseDate).reversed())
                .collect(Collectors.toList());
    }
}
