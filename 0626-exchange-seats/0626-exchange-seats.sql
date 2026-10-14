# Write your MySQL query statement below
SELECT
    CASE
        WHEN s1.id%2=1 AND s1.id<(SELECT MAX(id) FROM Seat)
            THEN s1.id+1
        WHEN s1.id%2=0
            THEN s1.id-1
        ELSE s1.id
    END AS id,
    s1.student
FROM Seat s1
ORDER BY id;