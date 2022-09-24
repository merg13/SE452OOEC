
-- RESERVATION SEED DATA
insert into reservation(id, created, description, start_time, showtime_id, customer_id) 
values(random_uuid(), CURRENT_TIMESTAMP(), 'Jurassic World', CURRENT_TIMESTAMP(), random_uuid(), random_uuid());

-- MOVIE SEED DATA
insert into movies(id, created, title, description, length)
values(random_uuid(), CURRENT_TIMESTAMP(), 'Movie1', 'Movie1 description...', 180);
insert into movies(id, created, title, description, length)
values(random_uuid(),  CURRENT_TIMESTAMP(),'Movie2', 'Movie2 description...', 127);
insert into movies(id, created, title, description, length)
values(random_uuid(),  CURRENT_TIMESTAMP(),'Movie3', 'Movie3 description...', 151);

-- SHOWTIME SEED DATA
insert into showtimes(id, movie_id, auditorium_id, showtime)
values (random_uuid(), random_uuid(), random_uuid(), CURRENT_TIMESTAMP());