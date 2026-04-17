# Write your MySQL query statement below
SELECT wc.id 
FROM Weather wp
CROSS JOIN Weather wc
WHERE DATEDIFF(wc.recordDate, wp.recordDate) = 1
and wc.temperature > wp.temperature 