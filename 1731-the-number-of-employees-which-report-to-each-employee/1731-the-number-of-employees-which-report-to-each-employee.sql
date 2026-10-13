# Write your MySQL query statement below
WITH ReportStats AS (
    SELECT
        reports_to AS manager_id,
        COUNT(*) AS reports_count,
        ROUND(AVG(age), 0) AS average_age
    FROM Employees
    WHERE reports_to IS NOT NULL
    GROUP BY reports_to
)
SELECT
    e.employee_id,
    e.name,
    r.reports_count,
    r.average_age
FROM Employees e
JOIN ReportStats r
    ON e.employee_id = r.manager_id
ORDER BY e.employee_id;