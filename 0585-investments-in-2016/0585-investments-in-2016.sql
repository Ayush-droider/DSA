# Write your MySQL query statement below
WITH C1 (pid,tiv_2015,tiv_2016,location) AS (
    SELECT
        i.pid AS pid,
        i.tiv_2015 AS tiv_2015,
        i.tiv_2016 AS tiv_2016,
        CONCAT(i.lat,',',i.lon) AS location
    FROM Insurance i
),

C2 AS (
    SELECT tiv_2015
    FROM C1
    GROUP BY tiv_2015
    HAVING COUNT(*)>1
),

C3 AS (
    SELECT location 
    FROM C1
    GROUP BY location
    HAVING COUNT(*)=1
)

SELECT ROUND(SUM(tiv_2016),2) AS tiv_2016
FROM C1
WHERE tiv_2015 IN (SELECT tiv_2015 FROM C2)
AND location IN (SELECT location FROM C3);