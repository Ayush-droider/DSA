# Write your MySQL query statement below
WITH C1 AS (
    SELECT 
        e.id AS id,
        e.name AS name,
        e.salary AS salary,
        d.name AS deptName
    FROM Employee e
    JOIN Department d
    ON e.departmentId=d.id
)

SELECT
    Department,
    Employee,
    Salary
FROM (
    SELECT
        id,
        name AS Employee,
        deptName AS Department,
        salary AS Salary,
        DENSE_RANK() OVER (PARTITION BY deptName ORDER BY salary DESC) AS rnk
    FROM C1
) AS ranked
WHERE rnk<=3;