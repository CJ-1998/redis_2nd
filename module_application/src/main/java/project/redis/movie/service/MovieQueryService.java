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

    // @Cacheable(cacheNames = "movieCache")
    @Cacheable(cacheNames = "redisCache")
    public List<NowPlayMovieDto> getNowPlayingMovies(String movieTitle, String movieGenre) {
        MovieGenre movieGenreEnum = getMovieGenre(movieGenre);

        List<ScreeningResponseDto> moviesGroupedByTheater
                = screeningRepository.findMoviesGroupedByTheater(movieTitle, movieGenreEnum, LocalDate.now());

        Map<String, Map<String, List<ScreeningResponseDto>>> groupedByMovieAndTheater
                = mapMovieInfoByMovieAndTheater(moviesGroupedByTheater);

        return extractNowPlayMovieDtos(groupedByMovieAndTheater);
    }

    private MovieGenre getMovieGenre(String movieGenre) {
        MovieGenre movieGenreEnum = null;

        if (movieGenre != null) {
            movieGenreEnum = MovieGenre.valueOf(movieGenre);
        }
        return movieGenreEnum;
    }

    private Map<String, Map<String, List<ScreeningResponseDto>>> mapMovieInfoByMovieAndTheater(
            List<ScreeningResponseDto> moviesGroupedByTheater) {
        return moviesGroupedByTheater.stream()
                .collect(Collectors.groupingBy(ScreeningResponseDto::getMovieTitle,
                        Collectors.groupingBy(ScreeningResponseDto::getCinemaAndTheaterName)));
    }

    private List<NowPlayMovieDto> extractNowPlayMovieDtos(
            Map<String, Map<String, List<ScreeningResponseDto>>> groupedByMovieAndTheater) {
        return groupedByMovieAndTheater.values().stream()
                .map(this::convertToNowPlayMovieDtos)
                .flatMap(List::stream)
                .sorted(Comparator.comparing(NowPlayMovieDto::getMovieReleaseDate).reversed())
                .collect(Collectors.toList());
    }

    private List<NowPlayMovieDto> convertToNowPlayMovieDtos(Map<String, List<ScreeningResponseDto>> stringListMap) {
        return stringListMap.values().stream()
                .map(this::createNowPlayMovieDto)
                .collect(Collectors.toList());
    }

    private NowPlayMovieDto createNowPlayMovieDto(List<ScreeningResponseDto> screenings) {
        List<ScreeningTimeDto> screeningTimeDtos = convertToScreeningTimeDtos(screenings);
        ScreeningResponseDto screeningResponseDto = screenings.get(0);
        return NowPlayMovieDto.createByQueryDto(screeningResponseDto, screeningTimeDtos);
    }

    private List<ScreeningTimeDto> convertToScreeningTimeDtos(List<ScreeningResponseDto> screenings) {
        return screenings.stream()
                .map(ScreeningTimeDto::createByQueryDto)
                .sorted(Comparator.comparing(ScreeningTimeDto::getStartTime))
                .collect(Collectors.toList());
    }
}
