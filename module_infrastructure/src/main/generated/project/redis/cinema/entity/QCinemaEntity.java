package project.redis.cinema.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCinemaEntity is a Querydsl query type for CinemaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCinemaEntity extends EntityPathBase<CinemaEntity> {

    private static final long serialVersionUID = -179277686L;

    public static final QCinemaEntity cinemaEntity = new QCinemaEntity("cinemaEntity");

    public final project.redis.common.entity.QBaseEntity _super = new project.redis.common.entity.QBaseEntity(this);

    public final NumberPath<Long> cinemaId = createNumber("cinemaId", Long.class);

    public final StringPath cinemaName = createString("cinemaName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public QCinemaEntity(String variable) {
        super(CinemaEntity.class, forVariable(variable));
    }

    public QCinemaEntity(Path<? extends CinemaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCinemaEntity(PathMetadata metadata) {
        super(CinemaEntity.class, metadata);
    }

}

