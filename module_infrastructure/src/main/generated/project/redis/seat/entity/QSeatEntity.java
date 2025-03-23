package project.redis.seat.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSeatEntity is a Querydsl query type for SeatEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeatEntity extends EntityPathBase<SeatEntity> {

    private static final long serialVersionUID = -394982862L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSeatEntity seatEntity = new QSeatEntity("seatEntity");

    public final project.redis.common.entity.QBaseEntity _super = new project.redis.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    public final BooleanPath isReserved = createBoolean("isReserved");

    public final NumberPath<Integer> seatColumn = createNumber("seatColumn", Integer.class);

    public final NumberPath<Long> seatId = createNumber("seatId", Long.class);

    public final StringPath seatRow = createString("seatRow");

    public final project.redis.theater.entity.QTheaterEntity theater;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public QSeatEntity(String variable) {
        this(SeatEntity.class, forVariable(variable), INITS);
    }

    public QSeatEntity(Path<? extends SeatEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSeatEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSeatEntity(PathMetadata metadata, PathInits inits) {
        this(SeatEntity.class, metadata, inits);
    }

    public QSeatEntity(Class<? extends SeatEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.theater = inits.isInitialized("theater") ? new project.redis.theater.entity.QTheaterEntity(forProperty("theater"), inits.get("theater")) : null;
    }

}

