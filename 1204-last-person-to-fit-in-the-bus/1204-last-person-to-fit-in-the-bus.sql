# Write your MySQL query statement below
WITH Ref AS (
    SELECT
        person_id,
        person_name,
        weight,
        turn,
        ROW_NUMBER() OVER (ORDER BY turn) AS rn
    FROM Queue
)
SELECT q1.person_name
FROM Ref q1
JOIN Ref q2
    ON q1.rn >= q2.rn
GROUP BY q1.person_id, q1.person_name, q1.turn
HAVING SUM(q2.weight) <= 1000
ORDER BY q1.turn DESC
LIMIT 1;