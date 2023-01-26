CREATE TABLE IF NOT EXISTS register (
  id serial,
  code VARCHAR (10) NOT NULL,
  registered_at CHAR (40) NOT NULL,
  assisted BOOLEAN NOT NULL,
  PRIMARY KEY (id),
  member_id SERIAL,
  FOREIGN KEY (member_id) REFERENCES member(id),
  conference_id SERIAL,
  FOREIGN KEY (conference_id) REFERENCES conference(id)
  );
