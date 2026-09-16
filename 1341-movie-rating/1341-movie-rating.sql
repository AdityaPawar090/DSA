# Write your MySQL query statement below
SELECT Results
FROM (
    SELECT Users.name AS results
    FROM MovieRating
    JOIN Users
        ON MovieRating.user_id = Users.user_id
    GROUP BY Users.user_id, 
        Users.name
    ORDER BY COUNT(*) DESC, 
        Users.name ASC
    LIMIT 1
) AS first_result

UNION ALL

SELECT Results
FROM (
    SELECT Movies.title AS results
    FROM MovieRating 
    JOIN Movies
        ON MovieRating.movie_id = Movies.movie_id
    WHERE MovieRating.created_at >= '2020-02-01'
        AND MovieRating.created_at < '2020-03-01'
    GROUP BY Movies.movie_id, 
        Movies.title
    ORDER BY AVG(MovieRating.rating) DESC, 
        Movies.title ASC
    LIMIT 1
) AS second_result;
