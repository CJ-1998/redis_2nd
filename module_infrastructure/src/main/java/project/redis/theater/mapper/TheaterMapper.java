package project.redis.theater.mapper;

import project.redis.theater.Theater;
import project.redis.theater.entity.TheaterEntity;

public interface TheaterMapper {
    Theater toDomain(TheaterEntity theaterEntity);
}
