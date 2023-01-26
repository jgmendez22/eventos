CREATE TABLE IF NOT EXISTS event (
  id serial,
  description VARCHAR (1000),
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  total_attendees INT,
  city CHAR(50),
  PRIMARY KEY (id)
);
