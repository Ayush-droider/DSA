# Write your MySQL query statement below
SELECT DISTINCT email AS Email
FROM Person p
GROUP BY Email
HAVING COUNT(*)>1;