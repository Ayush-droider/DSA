# Write your MySQL query statement below
SELECT 
    e.event_day as day,
    e.emp_id as emp_id,
    SUM(out_time-in_time) as total_time
FROM employees e
GROUP BY e.emp_id,DATE_FORMAT(event_day, '%Y-%m-%d');