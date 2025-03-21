package project.redis.theater.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.redis.cinema.entity.CinemaEntity;
import project.redis.common.entity.BaseEntity;
import project.redis.seat.entity.SeatEntity;

@Entity
@Table(name = "theater")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TheaterEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;

    @Column(nullable = false)
    private String theaterName;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private CinemaEntity cinema;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeatEntity> seats;
}
