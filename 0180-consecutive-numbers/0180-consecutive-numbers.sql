# Write your MySQL query statement below
-- SELECT DISTINCT l1.num AS ConsecutiveNums
-- FROM Logs l1,Logs l2,Logs l3
-- WHERE l1.num=l2.num
--   AND l2.num=l3.num
--   AND l1.id=l2.id-1
--   AND l2.id=l3.id-1;

WITH NextData(num,next_num,next_next_num) AS(
    SELECT
        num,
        LEAD(num, 1) OVER (ORDER BY id) AS next_num,
        LEAD(num, 2) OVER (ORDER BY id) AS next_next_num
    FROM Logs
)

SELECT DISTINCT l.num AS ConsecutiveNums
FROM(
    SELECT
        nd.num,nd.next_num,nd.next_next_num
    FROM NextData nd
)l
WHERE l.num=l.next_num
  AND l.num=l.next_next_num;