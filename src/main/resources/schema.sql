CREATE TABLE students (
  student_id   INTEGER  PRIMARY KEY auto_increment,
  first_name VARCHAR(50),
  last_name VARCHAR(50)
);

/*
CREATE VIEW rented_movies AS
SELECT movies.id as id,
  movies.title,
  movies.type,
  customer_movies.customer_id as customer_id
FROM movies, customer_movies
WHERE movies.id=customer_movies.movie_id;

CREATE VIEW customer_rents AS
SELECT customers.id as id,
  customers.name,
  customers.bonus_points,
  customer_movies.movie_id as movie_id
FROM customers, customer_movies
WHERE customers.id=customer_movies.customer_id;
*/
