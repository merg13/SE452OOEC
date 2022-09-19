
-- RESERVATION SEED DATA
CREATE table reservation(id uuid primary key, created datetime DEFAULT CURRENT_TIMESTAMP, description nvarchar, startTime datetime, showTimeId uuid, customerId uuid);
insert into reservation(id, description, startTime, showTimeId, customerId) values(random_uuid(), 'Jurassic World', CURRENT_TIMESTAMP(), random_uuid(), random_uuid());

-- insert into reservation(description nvarchar, startTime datetime, showTimeId uuid, customerId uuid)
-- values('Jurassic World', '2022-09-17 01:30:00:00.000', random_uuid(), random_uuid());

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