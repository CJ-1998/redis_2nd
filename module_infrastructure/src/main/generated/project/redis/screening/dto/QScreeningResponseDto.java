package project.redis.screening.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * project.redis.screening.dto.QScreeningResponseDto is a Querydsl Projection type for ScreeningResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QScreeningResponseDto extends ConstructorExpression<ScreeningResponseDto> {

    private static final long serialVersionUID = 1375596631L;

    public QScreeningResponseDto(com.querydsl.core.types.Expression<String> movieTitle, com.querydsl.core.types.Expression<project.redis.movie.MovieRate> rating, com.querydsl.core.types.Expression<java.time.LocalDate> releasedAt, com.querydsl.core.types.Expression<String> thumbnail, com.querydsl.core.types.Expression<Integer> duration, com.querydsl.core.types.Expression<project.redis.movie.MovieGenre> genre, com.querydsl.core.types.Expression<String> cinemaName, com.querydsl.core.types.Expression<String> theaterName, com.querydsl.core.types.Expression<? extends java.util.List<String>> screeningTimes) {
        super(ScreeningResponseDto.class, new Class<?>[]{String.class, project.redis.movie.MovieRate.class, java.time.LocalDate.class, String.class, int.class, project.redis.movie.MovieGenre.class, String.class, String.class, java.util.List.class}, movieTitle, rating, releasedAt, thumbnail, duration, genre, cinemaName, theaterName, screeningTimes);
    }

}

