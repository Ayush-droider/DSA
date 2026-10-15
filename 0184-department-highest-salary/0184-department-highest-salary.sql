SELECT Department,Employee,Salary
FROM(
    SELECT
        d.name AS Department,
        e.name AS Employee,
        e.salary AS Salary,
        DENSE_RANK() OVER (PARTITION BY d.id ORDER BY e.salary DESC) AS rnk
    FROM Employee e
    JOIN Department d
        ON d.id=e.departmentId
)t
WHERE rnk=1;
