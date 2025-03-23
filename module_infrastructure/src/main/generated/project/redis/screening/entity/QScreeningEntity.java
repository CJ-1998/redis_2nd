package project.redis.screening.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScreeningEntity is a Querydsl query type for ScreeningEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScreeningEntity extends EntityPathBase<ScreeningEntity> {

    private static final long serialVersionUID = 259575502L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScreeningEntity screeningEntity = new QScreeningEntity("screeningEntity");

    public final project.redis.common.entity.QBaseEntity _super = new project.redis.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    public final DateTimePath<java.time.LocalDateTime> endedAt = createDateTime("endedAt", java.time.LocalDateTime.class);

    public final project.redis.movie.entity.QMovieEntity movie;

    public final NumberPath<Long> screeningId = createNumber("screeningId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> startedAt = createDateTime("startedAt", java.time.LocalDateTime.class);

    public final project.redis.theater.entity.QTheaterEntity theater;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public QScreeningEntity(String variable) {
        this(ScreeningEntity.class, forVariable(variable), INITS);
    }

    public QScreeningEntity(Path<? extends ScreeningEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScreeningEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScreeningEntity(PathMetadata metadata, PathInits inits) {
        this(ScreeningEntity.class, metadata, inits);
    }

    public QScreeningEntity(Class<? extends ScreeningEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.movie = inits.isInitialized("movie") ? new project.redis.movie.entity.QMovieEntity(forProperty("movie")) : null;
        this.theater = inits.isInitialized("theater") ? new project.redis.theater.entity.QTheaterEntity(forProperty("theater"), inits.get("theater")) : null;
    }

}

