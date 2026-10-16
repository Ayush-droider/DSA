# Write your MySQL query statement below
SELECT
    a.sell_date,
    COUNT(DISTINCT a.product) AS num_sold,
    GROUP_CONCAT(DISTINCT a.product ORDER BY a.product SEPARATOR ',') AS products
FROM Activities a
GROUP BY a.sell_date
ORDER BY a.sell_date;