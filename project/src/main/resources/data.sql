-- -- ADMIN SEED DATA
-- insert into admin(id, created) 
-- values(random_uuid(), CURRENT_TIMESTAMP());

-- CUSTOMER SEED DATA
insert into customer(id, created, name) 
values(random_uuid(), CURRENT_TIMESTAMP(), 'John Smith');

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
insert into showtimes(id, created, movie_id, auditorium_id, showtime)
values (random_uuid(), CURRENT_TIMESTAMP(), random_uuid(), random_uuid(), CURRENT_TIMESTAMP());

-- AUDITORIUM SEED DATA
insert into auditorium(id, created, name,capacity) 
values(random_uuid(), CURRENT_TIMESTAMP(), 'Chicago Auditorium', 1000);

-- USER ROLE SEED DATA
INSERT INTO user_roles(name) VALUES('ROLE_CUSTOMER');
INSERT INTO user_roles(name) VALUES('ROLE_ADMIN');

-- USER SEED DATA
INSERT INTO users(email, password, username) VALUES('testUser1@email.com', '$2a$10$GsXUOJf7a03fYDncV4Wq9u2ViWTFecJHReOd1VMNHkuNN1X1jvvEK', 'testUser1');

-- USERS ROLE SEED DATA
INSERT INTO users_roles(user_id, role_id) VALUES(1, 1);