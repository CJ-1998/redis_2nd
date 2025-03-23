package project.redis.screening.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Builder;
import lombok.Getter;
import project.redis.screening.Screening;

@Getter
@Builder
public class ScreeningTimeDto {

    private static final String TIME_RANGE_SEPARATOR = " ~ ";

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    private String screeningTime;

    public ScreeningTimeDto() {
    }

    public ScreeningTimeDto(LocalDateTime startTime, LocalDateTime endTime, String screeningTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.screeningTime = screeningTime;
    }

    public static ScreeningTimeDto of(Screening screening) {
        LocalDateTime startTime = screening.getStartedAt();
        LocalDateTime endTime = screening.getEndedAt();
        String screeningTime = createScreeningTime(startTime, endTime);
        return ScreeningTimeDto.builder()
                .startTime(startTime)
                .endTime(endTime)
                .screeningTime(screeningTime)
                .build();
    }

    public static ScreeningTimeDto createByQueryDto(ScreeningResponseDto screeningResponseDto) {
        LocalDateTime startTime = screeningResponseDto.getStartedAt();
        LocalDateTime endTime = screeningResponseDto.getEndedAt();
        String screeningTime = createScreeningTime(startTime, endTime);
        return ScreeningTimeDto.builder()
                .startTime(startTime)
                .endTime(endTime)
                .screeningTime(screeningTime)
                .build();
    }

    private static String createScreeningTime(LocalDateTime startTime, LocalDateTime endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String screeningStartedAt = startTime.format(formatter);
        String screeningEndAt = endTime.format(formatter);
        return screeningStartedAt + TIME_RANGE_SEPARATOR + screeningEndAt;
    }
}
