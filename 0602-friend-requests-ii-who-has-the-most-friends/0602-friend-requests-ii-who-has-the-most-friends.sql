# Write your MySQL query statement below
WITH Answer (id) AS (SELECT requester_id as id
FROM RequestAccepted

UNION ALL

SELECT accepter_id as id
FROM RequestAccepted)

SELECT a.id,COUNT(*) AS num
FROM Answer a 
GROUP BY a.id
ORDER BY num DESC
LIMIT 1;