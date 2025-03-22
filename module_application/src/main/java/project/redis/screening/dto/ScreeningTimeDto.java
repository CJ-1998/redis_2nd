package project.redis.screening.dto;

import java.time.format.DateTimeFormatter;
import lombok.Builder;
import lombok.Getter;
import project.redis.screening.Screening;

@Getter
@Builder
public class ScreeningTimeDto {

    private static final String TIME_RANGE_SEPARATOR = " ~ ";
    private String screeningTime;

    public static ScreeningTimeDto of(Screening screening) {
        String screeningTime = createScreeningTime(screening);
        return ScreeningTimeDto.builder()
                .screeningTime(screeningTime)
                .build();
    }

    private static String createScreeningTime(Screening screening) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String screeningStartedAt = screening.getStartedAt().format(formatter);
        String screeningEndAt = screening.getEndedAt().format(formatter);
        return screeningStartedAt + TIME_RANGE_SEPARATOR + screeningEndAt;
    }
}
