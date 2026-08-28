SELECT 
    Register.contest_id,
    ROUND(
        COUNT(Register.user_id) * 100.0 / (SELECT COUNT(*) FROM Users),
        2
    ) AS percentage
FROM Users
RIGHT JOIN Register
    ON Users.user_id = Register.user_id
GROUP BY Register.contest_id
ORDER BY percentage DESC, contest_id ASC;