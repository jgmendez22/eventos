CREATE TABLE IF NOT EXISTS conference (
  id serial,
  title VARCHAR (100) NOT NULL,
  speaker VARCHAR(100) NOT NULL,
  hora TIME NOT NULL,
  dia DATE NOT NULL,
  total_attendees INT,
  event_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (event_id) REFERENCES event(id)
);
