/** 
 *	The employee table holds all employees. Every employee has an ID, and there is also a solumn for the department ID
 *		+----+-------+--------+--------------+
 *		| Id | Name  | Salary | DepartmentId |
 *		| 2  | Henry | 80000  | 2            |
 *		| 1  | Joe   | 70000  | 1            |
 *		+----+-------+--------+--------------+
 *		| 3  | Sam   | 60000  | 2            |
 *		| 4  | Max   | 90000  | 1            |
 *		| 5  | Janet | 69000  | 1            |
 *		| 6  | Randy | 85000  | 1            |
 *		+----+-------+--------+--------------+
 *	The Department table holds all departments of the company
 *		+----+----------+
 *		| Id | Name     |
 *		+----+----------+
 *		| 1  | IT       |
 *		| 2  | Sales    |
 *		+----+----------+
 *	Write a SQL query to find employees who earn the top three salaries in each of the department.
 *	For the above table, your SQL query should return the following rows. 
 *      +------------+----------+--------+
 *      | Department | Employee | Salary |
 *      +------------+----------+--------+
 *      | IT         | Max      | 90000  |
 *      | IT         | Randy    | 85000  |
 *      | IT         | Joe      | 70000  |
 *      | Sales      | Henry    | 80000  |
 *      | Sales      | Sam      | 60000  |
 *      +------------+----------+--------+
 **/

