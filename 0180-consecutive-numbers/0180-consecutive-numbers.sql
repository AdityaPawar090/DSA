# Write your MySQL query statement below
SELECT DISTINCT num AS consecutiveNums
FROM ( 
    SELECT
        num, 
        LAG(num, 1) OVER (ORDER BY id) AS prev_num,
        LAG(num, 2) OVER (ORDER BY id) AS prev_num1
        FROM Logs
    ) t
    WHERE num = prev_num
     AND num = prev_num1;