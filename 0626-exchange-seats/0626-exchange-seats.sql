# Write your MySQL query statement below
WITH largestId (max) AS (
    SELECT MAX(id)as max FROM Seat
)
SELECT
    CASE
        WHEN s1.id%2=1 AND s1.id<(SELECT max FROM largestId)
            THEN s1.id+1
        WHEN s1.id%2=0
            THEN s1.id-1
        ELSE s1.id
    END AS id,
    s1.student
FROM Seat s1
ORDER BY id;