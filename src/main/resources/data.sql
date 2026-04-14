CREATE TABLE movie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    language VARCHAR(50),
    genre VARCHAR(50)
);

CREATE TABLE theatre (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(100)
);

CREATE TABLE show_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id BIGINT,
    theatre_id BIGINT,
    date DATE,
    start_time TIME,
    price DOUBLE
);

CREATE TABLE seat (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    seat_number VARCHAR(10),
    available BOOLEAN,
    show_id BIGINT
);

CREATE TABLE booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    show_id BIGINT,
    total_amount DOUBLE
);

CREATE TABLE booking_seats (
    booking_id BIGINT,
    seat_id BIGINT
);

CREATE INDEX idx_movie_name ON movie(name);
CREATE INDEX idx_theatre_city ON theatre(city);
CREATE INDEX idx_show_movie ON show_table(movie_id);
CREATE INDEX idx_show_theatre ON show_table(theatre_id);
CREATE INDEX idx_seat_show ON seat(show_id);