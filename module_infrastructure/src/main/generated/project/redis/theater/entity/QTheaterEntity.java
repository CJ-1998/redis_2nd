package project.redis.theater.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTheaterEntity is a Querydsl query type for TheaterEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTheaterEntity extends EntityPathBase<TheaterEntity> {

    private static final long serialVersionUID = 1353519278L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTheaterEntity theaterEntity = new QTheaterEntity("theaterEntity");

    public final project.redis.common.entity.QBaseEntity _super = new project.redis.common.entity.QBaseEntity(this);

    public final project.redis.cinema.entity.QCinemaEntity cinema;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    public final ListPath<project.redis.seat.entity.SeatEntity, project.redis.seat.entity.QSeatEntity> seats = this.<project.redis.seat.entity.SeatEntity, project.redis.seat.entity.QSeatEntity>createList("seats", project.redis.seat.entity.SeatEntity.class, project.redis.seat.entity.QSeatEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> theaterId = createNumber("theaterId", Long.class);

    public final StringPath theaterName = createString("theaterName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public QTheaterEntity(String variable) {
        this(TheaterEntity.class, forVariable(variable), INITS);
    }

    public QTheaterEntity(Path<? extends TheaterEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTheaterEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTheaterEntity(PathMetadata metadata, PathInits inits) {
        this(TheaterEntity.class, metadata, inits);
    }

    public QTheaterEntity(Class<? extends TheaterEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cinema = inits.isInitialized("cinema") ? new project.redis.cinema.entity.QCinemaEntity(forProperty("cinema")) : null;
    }

}

