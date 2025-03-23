-- Cinema 테이블 생성
CREATE TABLE IF NOT EXISTS cinema (
    cinema_id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 영화관 ID
    cinema_name VARCHAR(255) NOT NULL  -- 영화관 이름
    created_by BIGINT NULL,            -- BaseEntity 필드
    created_at DATETIME NULL,          -- BaseEntity 필드
    updated_by BIGINT NULL,            -- BaseEntity 필드
    updated_at DATETIME NULL           -- BaseEntity 필드
);

-- Movie 테이블 생성
CREATE TABLE IF NOT EXISTS movie (
    movie_id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 영화 ID
    title VARCHAR(255) NOT NULL,  -- 영화 제목
    rating VARCHAR(50) NOT NULL,  -- 영화 등급 (Enum 값으로 저장, 예: 'G', 'PG', 'R' 등)
    released_at DATE NOT NULL,  -- 개봉일
    thumbnail VARCHAR(500),  -- 영화 썸네일
    duration INT NOT NULL,  -- 영화 상영 시간 (분)
    genre VARCHAR(50) NOT NULL,  -- 영화 장르 (Enum 값으로 저장)
    created_by BIGINT NULL,            -- BaseEntity 필드
    created_at DATETIME NULL,          -- BaseEntity 필드
    updated_by BIGINT NULL,            -- BaseEntity 필드
    updated_at DATETIME NULL           -- BaseEntity 필드
);

-- Screening 테이블 생성
CREATE TABLE IF NOT EXISTS screening (
    screening_id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 상영 ID
    started_at DATETIME NOT NULL,  -- 상영 시작 시간
    ended_at DATETIME NOT NULL,  -- 상영 종료 시간
    movie_id BIGINT NOT NULL,  -- 영화 ID (Foreign Key)
    theater_id BIGINT NOT NULL,  -- 극장 ID (Foreign Key)
    created_by BIGINT NULL,            -- BaseEntity 필드
    created_at DATETIME NULL,          -- BaseEntity 필드
    updated_by BIGINT NULL,            -- BaseEntity 필드
    updated_at DATETIME NULL,          -- BaseEntity 필드
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id) ON DELETE CASCADE,  -- 영화 외래키
    FOREIGN KEY (theater_id) REFERENCES theater(theater_id) ON DELETE CASCADE  -- 극장 외래키
);

-- Seat 테이블 생성
CREATE TABLE IF NOT EXISTS seat (
    seat_id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 좌석 ID
    is_reserved BOOLEAN NOT NULL,  -- 예약 여부
    seat_row VARCHAR(10) NOT NULL,  -- 좌석 행 (예: A, B, C 등)
    seat_column INT NOT NULL,  -- 좌석 열 (예: 1, 2, 3 등)
    theater_id BIGINT NOT NULL,  -- 극장 ID (Foreign Key)
    created_by BIGINT NULL,            -- BaseEntity 필드
    created_at DATETIME NULL,          -- BaseEntity 필드
    updated_by BIGINT NULL,            -- BaseEntity 필드
    updated_at DATETIME NULL,          -- BaseEntity 필드
    FOREIGN KEY (theater_id) REFERENCES theater(theater_id) ON DELETE CASCADE  -- 극장 외래키
);

-- Theater 테이블 생성
CREATE TABLE IF NOT EXISTS theater (
    theater_id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 극장 ID
    theater_name VARCHAR(255) NOT NULL,  -- 극장 이름
    cinema_id BIGINT NOT NULL,  -- 영화관 ID (Foreign Key)
    created_by BIGINT NULL,            -- BaseEntity 필드
    created_at DATETIME NULL,          -- BaseEntity 필드
    updated_by BIGINT NULL,            -- BaseEntity 필드
    updated_at DATETIME NULL,          -- BaseEntity 필드
    FOREIGN KEY (cinema_id) REFERENCES cinema(cinema_id) ON DELETE CASCADE  -- 영화관 외래키
);

CREATE INDEX idx_movie_released_title_genre ON movie(released_at, title, genre);
CREATE INDEX idx_screening_started_at ON screening(started_at);

