CREATE TABLE students (
  student_id   INTEGER  PRIMARY KEY auto_increment,
  first_name VARCHAR(50),
  last_name VARCHAR(50)
);

CREATE TABLE schools (
  school_id  INTEGER  PRIMARY KEY auto_increment,
  school_name VARCHAR(50),
  school_level CHAR(20)
);

