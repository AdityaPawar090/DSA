# Write your MySQL query statement below
SELECT id
FROM (
    SELECT
        id,
        recordDate,
        temperature,
        LAG(recordDate) OVER (ORDER BY recordDate) AS previous_date,
        LAG(temperature) OVER (ORDER BY recordDate) AS previous_temperature
    FROM Weather
) AS w
WHERE temperature > previous_temperature
  AND recordDate = DATE_ADD(previous_date, INTERVAL 1 DAY);