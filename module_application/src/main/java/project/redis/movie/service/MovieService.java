package project.redis.movie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.redis.movie.Movie;
import project.redis.movie.adapter.MovieAdapter;
import project.redis.movie.dto.NowPlayMovieDto;
import project.redis.screening.Screening;
import project.redis.screening.adapter.ScreeningAdapter;
import project.redis.screening.dto.ScreeningTimeDto;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieAdapter movieAdapter;
    private final ScreeningAdapter screeningAdapter;

    public List<NowPlayMovieDto> getNowPlayingMovies() {
        List<Movie> movies = movieAdapter.findMovies();
        List<Movie> nowPlayingMovies = findNowPlayingMovies(movies);

        return makeNowPlayingMoviesInfo(nowPlayingMovies);
    }

    private List<Movie> findNowPlayingMovies(List<Movie> movies) {
        LocalDate today = LocalDate.now();

        return movies.stream()
                .filter(movie -> movie.isReleasedBefore(today))
                .sorted(Movie::compareReleaseDate)
                .collect(Collectors.toList());
    }

    private List<NowPlayMovieDto> makeNowPlayingMoviesInfo(List<Movie> movies) {
        List<NowPlayMovieDto> nowPlayMovieDtos = new ArrayList<>();
        for (Movie movie : movies) {
            List<Screening> movieAllScreening = screeningAdapter.findScreeningsByMovie(movie);

            Map<String, List<Screening>> cinemaNameScreening = mapByCinemaName(movieAllScreening);

            createNowPlayMovieDtoByMap(movie, cinemaNameScreening, nowPlayMovieDtos);
        }
        nowPlayMovieDtos.sort(Comparator.comparing(NowPlayMovieDto::getReleasedAt).reversed());
        return nowPlayMovieDtos;
    }

    private Map<String, List<Screening>> mapByCinemaName(List<Screening> movieAllScreening) {
        return movieAllScreening.stream()
                .collect(Collectors.groupingBy(Screening::fetchTheaterAndCinemaName));
    }

    private void createNowPlayMovieDtoByMap(Movie movie, Map<String, List<Screening>> cinemaNameScreening,
                                            List<NowPlayMovieDto> nowPlayMovieDtos) {
        for (Map.Entry<String, List<Screening>> entry : cinemaNameScreening.entrySet()) {
            NowPlayMovieDto nowPlayMovieDto = createNowPlayMovieDtoByEntry(movie, entry);
            nowPlayMovieDtos.add(nowPlayMovieDto);
        }
    }

    private NowPlayMovieDto createNowPlayMovieDtoByEntry(Movie movie, Entry<String, List<Screening>> entry) {
        String theaterAndCinemaName = entry.getKey();
        List<Screening> screenings = entry.getValue();

        List<ScreeningTimeDto> screeningTimeDtos = makeScreeningTimeDtos(screenings);

        return NowPlayMovieDto.of(movie, theaterAndCinemaName, screeningTimeDtos);
    }

    private List<ScreeningTimeDto> makeScreeningTimeDtos(List<Screening> screenings) {
        List<ScreeningTimeDto> screeningTimeDtos
                = new ArrayList<>(screenings.stream().map(ScreeningTimeDto::of).toList());
        screeningTimeDtos.sort(Comparator.comparing(ScreeningTimeDto::getStartTime));
        return screeningTimeDtos;
    }

}
