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

        List<ScreeningResponseDto> nowPlayingMovies
                = screeningRepository.findNowPlayMoviesByQuery(movieTitle, movieGenreEnum, LocalDate.now());

        Map<String, List<ScreeningResponseDto>> nowPlayingMoviesGroupedByTitle
                = getNowPlayingMoviesGroupedByTitle(nowPlayingMovies);

        Map<String, List<ScreeningResponseDto>> nowPlayingMoviesGroupedByTitleAndTheater
                = getNowPlayingMoviesGroupedByTitleAndTheater(nowPlayingMoviesGroupedByTitle);

        return makeNowPlayMovieDtos(nowPlayingMoviesGroupedByTitleAndTheater);
    }

    private MovieGenre getMovieGenre(String movieGenre) {
        MovieGenre movieGenreEnum = null;

        if (movieGenre != null) {
            movieGenreEnum = MovieGenre.valueOf(movieGenre);
        }
        return movieGenreEnum;
    }

    private static Map<String, List<ScreeningResponseDto>> getNowPlayingMoviesGroupedByTitle(
            List<ScreeningResponseDto> nowPlayingMovies) {
        return nowPlayingMovies.stream().collect(Collectors.groupingBy(ScreeningResponseDto::getMovieTitle));
    }

    private static Map<String, List<ScreeningResponseDto>> getNowPlayingMoviesGroupedByTitleAndTheater(
            Map<String, List<ScreeningResponseDto>> nowPlayingMoviesGroupedByTitle) {
        return nowPlayingMoviesGroupedByTitle.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(ScreeningResponseDto::getCinemaAndTheaterName));
    }

    private List<NowPlayMovieDto> makeNowPlayMovieDtos(
            Map<String, List<ScreeningResponseDto>> nowPlayingMoviesGroupedByTitleAndTheater) {
        return nowPlayingMoviesGroupedByTitleAndTheater.values().stream()
                .map(this::makeNowPlayMovieDto)
                .sorted(Comparator.comparing(NowPlayMovieDto::getReleasedAt).reversed())
                .collect(Collectors.toList());
    }

    private NowPlayMovieDto makeNowPlayMovieDto(List<ScreeningResponseDto> screeningInfos) {
        List<ScreeningTimeDto> screeningTimeDto = convertToScreeningTimeDto(screeningInfos);
        ScreeningResponseDto screeningResponseDto = screeningInfos.get(0);
        return NowPlayMovieDto.createByQueryDto(screeningResponseDto, screeningTimeDto);
    }

    private List<ScreeningTimeDto> convertToScreeningTimeDto(List<ScreeningResponseDto> screeningInfos) {
        return screeningInfos.stream()
                .map(ScreeningTimeDto::createByQueryDto)
                .sorted(Comparator.comparing(ScreeningTimeDto::getStartTime))
                .collect(Collectors.toList());
    }
}
