package project.redis.movie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.redis.movie.Movie;
import project.redis.movie.adapter.MovieAdapter;
import project.redis.movie.dto.NowPlayMovieDto;
import project.redis.screening.Screening;
import project.redis.screening.adapter.ScreeningAdapter;

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
        return nowPlayMovieDtos;
    }

    private Map<String, List<Screening>> mapByCinemaName(List<Screening> movieAllScreening) {
        return movieAllScreening.stream()
                .collect(Collectors.groupingBy(Screening::getCinemaName));
    }

    private void createNowPlayMovieDtoByMap(Movie movie, Map<String, List<Screening>> cinemaNameScreening,
                                            List<NowPlayMovieDto> nowPlayMovieDtos) {
        for (Map.Entry<String, List<Screening>> entry : cinemaNameScreening.entrySet()) {
            String cinemaName = entry.getKey();
            List<Screening> screenings = entry.getValue();
            NowPlayMovieDto nowPlayMovieDto = NowPlayMovieDto.of(movie, cinemaName, screenings);
            nowPlayMovieDtos.add(nowPlayMovieDto);
        }
    }

}
