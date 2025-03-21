INSERT INTO cinema (cinema_name, created_by, created_at, updated_by, updated_at)
VALUES
    ('Cinema 1', null, null, null, null),
    ('Cinema 2', null, null, null, null),
    ('Cinema 3', null, null, null, null),
    ('Cinema 4', null, null, null, null),
    ('Cinema 5', null, null, null, null);

INSERT INTO theater (theater_name, cinema_id, created_by, created_at, updated_by, updated_at)
VALUES
    ('Theater a1', 1, null, null, null, null),
    ('Theater a2', 1, null, null, null, null),
    ('Theater b1', 2, null, null, null, null),
    ('Theater b2', 2, null, null, null, null),
    ('Theater c1', 3, null, null, null, null),
    ('Theater c2', 3, null, null, null, null),
    ('Theater d1', 4, null, null, null, null),
    ('Theater d2', 4, null, null, null, null),
    ('Theater e1', 5, null, null, null, null),
    ('Theater e2', 5, null, null, null, null);

INSERT INTO movie (title, rating, released_at, thumbnail, duration, genre, created_by, created_at, updated_by, updated_at)
VALUES
    ('Movie 1', 'ALL', '2025-03-01', 'thumbnail1.jpg', 120, 'ACTION', null, null, null, null),
    ('Movie 2', 'TWELVE', '2025-03-05', 'thumbnail2.jpg', 90, 'ROMANCE', null, null, null, null),
    ('Movie 3', 'FIFTEEN', '2025-03-10', 'thumbnail3.jpg', 105, 'ACTION', null, null, null, null),
    ('Movie 4', 'ALL', '2025-02-18', 'thumbnail4.jpg', 115, 'HORROR', null, null, null, null),
    ('Movie 5', 'NINETEEN', '2025-03-19', 'thumbnail5.jpg', 125, 'ACTION', null, null, null, null),
    ('Movie 6', 'TWELVE', '2025-01-11', 'thumbnail6.jpg', 103, 'SF', null, null, null, null),
    ('Movie 7', 'RESTRICT', '2024-06-10', 'thumbnail7.jpg', 94, 'SF', null, null, null, null),
    ('Movie 8', 'FIFTEEN', '2024-12-22', 'thumbnail8.jpg', 125, 'ROMANCE', null, null, null, null),
    ('Movie 9', 'NINETEEN', '2025-03-07', 'thumbnail9.jpg', 115, 'SF', null, null, null, null),
    ('Movie 10', 'RESTRICT', '2025-03-19', 'thumbnai20.jpg', 105, 'HORROR', null, null, null, null);


INSERT INTO screening (started_at, ended_at, movie_id, theater_id, created_by, created_at, updated_by, updated_at)
VALUES
    ('2025-03-21 10:00:00', '2025-03-21 12:00:00', 1, 1, null, null, null, null),
    ('2025-03-21 12:30:00', '2025-03-21 14:30:00', 2, 1, null, null, null, null),
    ('2025-03-21 15:00:00', '2025-03-21 17:00:00', 3, 2, null, null, null, null);

INSERT INTO seat (is_reserved, seat_row, seat_column, theater_id, created_by, created_at, updated_by, updated_at)
VALUES
    (FALSE, 'A', 1, 1, null, null, null, null),
    (FALSE, 'A', 1, 2, null, null, null, null),
    (FALSE, 'A', 1, 3, null, null, null, null),
    (FALSE, 'A', 1, 4, null, null, null, null),
    (FALSE, 'A', 1, 5, null, null, null, null),
    (FALSE, 'A', 1, 6, null, null, null, null),
    (FALSE, 'A', 1, 7, null, null, null, null),
    (FALSE, 'A', 1, 8, null, null, null, null),
    (FALSE, 'A', 1, 9, null, null, null, null),
    (FALSE, 'A', 1, 10, null, null, null, null);
