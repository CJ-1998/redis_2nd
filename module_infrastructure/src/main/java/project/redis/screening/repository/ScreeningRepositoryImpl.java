package project.redis.screening.repository;

import static project.redis.cinema.entity.QCinemaEntity.cinemaEntity;
import static project.redis.movie.entity.QMovieEntity.movieEntity;
import static project.redis.screening.entity.QScreeningEntity.screeningEntity;
import static project.redis.theater.entity.QTheaterEntity.theaterEntity;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.group.GroupBy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.redis.movie.MovieGenre;
import project.redis.screening.dto.QScreeningResponseDto;
import project.redis.screening.dto.ScreeningResponseDto;

@Repository
@RequiredArgsConstructor
public class ScreeningRepositoryImpl implements ScreeningRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ScreeningResponseDto> findMoviesGroupedByTheater(String movieTitle, MovieGenre movieGenre,
                                                                 LocalDate today) {
        BooleanBuilder builder = createBooleanBuilder(movieTitle, movieGenre, today);

        // QueryDSL을 사용한 상영관 별 영화 리스트 그룹화
        Map<Long, ScreeningResponseDto> result = jpaQueryFactory
                .from(screeningEntity)
                .join(screeningEntity.movie, movieEntity)
                .join(screeningEntity.theater, theaterEntity)
                .join(theaterEntity.cinema, cinemaEntity)
                .where(builder)
                .orderBy(movieEntity.releasedAt.desc(),
                        screeningEntity.startedAt.asc()) // ✅ releasedAt 최신순 + startedAt 오름차순 정렬
                .transform(GroupBy.groupBy(theaterEntity.theaterId).as(
                        new QScreeningResponseDto(
                                movieEntity.title,
                                movieEntity.rating,
                                movieEntity.releasedAt,
                                movieEntity.thumbnail,
                                movieEntity.duration,
                                movieEntity.genre,
                                cinemaEntity.cinemaName,
                                theaterEntity.theaterName,
                                GroupBy.list(
                                        screeningEntity.startedAt.stringValue()
                                                .concat(" ~ ")
                                                .concat(screeningEntity.endedAt.stringValue())
                                )
                        )
                ));

        return List.copyOf(result.values());
    }

    private BooleanBuilder createBooleanBuilder(String movieTitle, MovieGenre movieGenre, LocalDate today) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(movieEntity.releasedAt.before(today)); // 현재 날짜보다 이전인 영화만

        if (movieTitle != null && !movieTitle.isEmpty()) {
            builder.and(movieEntity.title.containsIgnoreCase(movieTitle)); // 제목 검색
        }
        if (movieGenre != null) {
            builder.and(movieEntity.genre.eq(movieGenre)); // 장르 검색
        }
        return builder;
    }
}
