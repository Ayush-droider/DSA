# Write your MySQL query statement below
SELECT name AS results
FROM(
    SELECT
        u.user_id,
        u.name,
        COUNT(*) AS total_ratings,
        DENSE_RANK() OVER (
            ORDER BY COUNT(*) DESC, u.name ASC
        ) AS rn
    FROM Users u
    JOIN MovieRating mr
        ON u.user_id=mr.user_id
    GROUP BY u.user_id, u.name
) AS t
WHERE rn=1

UNION ALL

-- SELECT m.movie_id,m.title,AVG(mr.rating) as average_rating
-- FROM Movies m
-- JOIN MovieRating mr
-- ON m.movie_id=mr.movie_id
-- WHERE DATE_FORMAT(created_at,'%Y-%m')='2020-02'
-- GROUP BY m.movie_id,m.title
-- ORDER BY average_rating DESC, m.title ASC;

-- SELECT m.title, AVG(mr.rating) AS average_rating
-- FROM Movies m
-- JOIN MovieRating mr
--     ON m.movie_id = mr.movie_id
-- WHERE DATE_FORMAT(mr.created_at, '%Y-%m') = '2020-02'
-- GROUP BY m.movie_id, m.title
-- ORDER BY average_rating DESC, m.title ASC
-- LIMIT 1;

SELECT title AS results
FROM (
    SELECT
        m.movie_id,
        m.title,
        AVG(mr.rating) AS average_rating,
        DENSE_RANK() OVER (
            ORDER BY AVG(mr.rating) DESC, m.title ASC
        ) AS rn
    FROM Movies m
    JOIN MovieRating mr
        ON m.movie_id = mr.movie_id
    WHERE DATE_FORMAT(mr.created_at, '%Y-%m') = '2020-02'
    GROUP BY m.movie_id, m.title
) AS t
WHERE rn = 1;