CREATE TABLE IF NOT EXISTS member (
  id serial,
  fullname VARCHAR (100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  AGE INT,
  PRIMARY KEY (id)
);
