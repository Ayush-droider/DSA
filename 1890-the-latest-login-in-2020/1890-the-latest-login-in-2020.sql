# Write your MySQL query statement below
SELECT 
    l.user_id,
    MAX(l.time_stamp) as last_stamp
FROM Logins l
WHERE YEAR(l.time_stamp)='2020'
GROUP BY user_id;