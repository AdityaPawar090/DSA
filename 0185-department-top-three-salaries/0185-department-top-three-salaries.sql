# Write your MySQL query statement below
SELECT Department, Employee, Salary
FROM  (
    SELECT Department.name AS Department,
        Employee.name AS Employee,
        Employee.salary,
        DENSE_RANK() OVER (
            PARTITION BY Department.name
            ORDER BY Employee.salary DESC
        ) AS rnk
    FROM Employee
    JOIN Department 
        ON Employee.departmentId = Department.id
) t
WHERE rnk <= 3;