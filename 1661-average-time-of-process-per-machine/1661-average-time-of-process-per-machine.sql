# Write your MySQL query statement below
SELECT machine_id, 
ROUND(AVG(timestamp - previous_timestamp), 3) AS processing_time
FROM (
    SELECT
    machine_id,
    process_id,
    activity_type,
    timestamp,
    LAG(timestamp) OVER (
        PARTITION BY machine_id, process_id
        ORDER BY timestamp
    ) AS previous_timestamp
    FROM Activity
) AS t
WHERE activity_type = 'end'
GROUP BY machine_id;