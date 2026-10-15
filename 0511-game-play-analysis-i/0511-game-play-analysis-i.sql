# Write your MySQL query statement below
SELECT player_id, event_date AS first_login
FROM(
    SELECT
        player_id,
        event_date,
        DENSE_RANK() OVER (
            PARTITION BY player_id
            ORDER BY event_date ASC
        ) AS rnk
    FROM Activity
)t
WHERE rnk=1;