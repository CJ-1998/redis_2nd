package project.redis.movie.controller;

import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.redis.movie.dto.NowPlayMovieDto;
import project.redis.movie.service.MovieQueryService;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieQueryService movieQueryService;
    //private final MovieService movieService;

    @GetMapping("/now-playing")
    public ResponseEntity<List<NowPlayMovieDto>> getNowPlayingMovies(
            @RequestParam(required = false, name = "movieTitle")
            @Size(max = 255, message = "Title length must not exceed 255 characters")
            String movieTitle,
            @RequestParam(required = false, name = "movieGenre")
            String movieGenre) {
        List<NowPlayMovieDto> nowPlayMovieDtos = movieQueryService.getNowPlayingMovies(movieTitle, movieGenre);
        // List<NowPlayMovieDto> nowPlayMovieDtos = movieService.getNowPlayingMovies();
        return ResponseEntity.ok(nowPlayMovieDtos);
    }
}
