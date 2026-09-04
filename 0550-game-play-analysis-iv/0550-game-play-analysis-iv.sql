WITH f AS (
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
)
SELECT ROUND(COUNT(a.player_id) / COUNT(f.player_id), 2) AS fraction
FROM f
LEFT JOIN Activity a
ON a.player_id = f.player_id
AND a.event_date = f.first_date + INTERVAL 1 DAY;