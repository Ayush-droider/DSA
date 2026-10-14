# Write your MySQL query statement below

WITH EmpData AS(
    SELECT employee_id
    FROM Employees
)
SELECT e.employee_id
FROM Employees e
WHERE e.salary < 30000
  AND e.manager_id NOT IN (
      SELECT ed.employee_id
      FROM EmpData ed
  )
ORDER BY e.employee_id;
