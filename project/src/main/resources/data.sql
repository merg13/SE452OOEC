
-- RESERVATION SEED DATA
CREATE table reservation(id int primary key, created datetime DEFAULT CURRENT_TIMESTAMP, description nvarchar, startTime datetime, showTimeId uuid, customerId uuid);

-- insert into reservation(description nvarchar, startTime datetime, showTimeId uuid, customerId uuid)
-- values('Jurassic World', '2022-09-17 01:30:00:00.000', random_uuid(), random_uuid());