# Write your MySQL query statement below
Update Salary
Set sex=CASE
WHEN sex='m' THEN 'f'
WHEN sex='f' THEN 'm'
END;