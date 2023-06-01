--I want to create two tables with a relationship 
-- I can accomplish this with primary keys and foreign keys
--Foreign keys of one table point to primary keys of another table. THIS ESTABLISHES A RELATIONSHIP

--This schema will track employees and their roles

--roles TABLE 
CREATE TABLE roles(

	role_id serial PRIMARY KEY, --The PRIMARY KEY uniquely identifies EACH record (row) IN a TABLE
	--serial is an auto-incrementing int data type - perfect primary keys, which must be unique 
	--whenever we insert a new record, the primary key will get populated and incremented for us 
	role_title TEXT UNIQUE, --now, EVERY ROLE must have a different title FROM EACH other
	role_salary int check(role_salary > 20000) --thanks TO the CHECK CONSTRAINT, salaries cannot be less than 20000
);



--employees table
CREATE TABLE employees(

	employee_id serial PRIMARY KEY, --same AS above. UNIQUE identifier that automatically increments.
	first_name TEXT NOT NULL, --EVERY employee must have a FIRST (not null)
	last_name TEXT NOT NULL, 
	role_id_fk int REFERENCES roles(role_id) --this IS a FOREIGN KEY. (not the "references keyword)
	
	/*this is saying every employee has a role. This foreign key point to the primary key in the roles table
	 THIS IS HOW WE ESTABLISH RELATIONSHIPS BETWEEN TABLES
	 Now, every employee must have a tole, and a role can have one, many, or no employess related to it
	 */
);
	

--DML---------------------
--Data Manipulation Language - SELECT, INSERT, UPDATE, DELETE (SELECT may also be considered DQL as opposed to DML)


/*INSERT some data into my tables
 
  we specify wwhat table and columns we're filling with data 
  (we don't need to put a value for the auto-incrementing serial)
  and then, we speicy what data we actually want to insert
  each pair of paranthesis will be different record in the table*/

INSERT INTO roles(role_title, role_salary)
VALUES ('Manager', 100000),
	   ('Cashier', 40000), 
	   ('Fry cook', 50000), 
       ('Marketing director', 100000);
      
 --we can use SELECT to view data in the table
SELECT * FROM roles; --* means "everything", we're saying "select everything from the roles table"


INSERT INTO employees(first_name, last_name, role_id_fk)
VALUES ('Eugene', 'Krabs', 1),
	   ('Spongebob', 'Squarepants', 3),
	   ('Squidward', 'Tentacle', 2),
	   ('Sheldon', 'Plankton', 1);

SELECT * FROM employees;



--The WHERE CLAUSE-------------
--The WHERE clause in a SELECT statement lets us further filter the data that comes back

--all roles where role_salary is 100,000 (=)
SELECT * FROM roles WHERE role_salary = 100000;

--all roles where role_salary is NOT 100,000 (!=)
SELECT * FROM roles WHERE role_salary != 100000;

--all roles where role_salary is less than 100,000 (<)
SELECT * FROM roles WHERE role_salary < 100000;

--all employees who have a first name starting with 'S' (LIKE %)
SELECT * FROM employees WHERE first_name LIKE 'S%'
--employees who;s names start with S (and the rest doesn't matter)

--all employees with a salary BETWEEN 30000 and 70000 (BETWEEN)
SELECT * FROM roles WHERE role_salary BETWEEN 30000 AND 70000;

--all employees named eugene OR sheldon (OR)
SELECT * FROM employees WHERE first_name = 'Eugene' OR first_name = 'Sheldon';

--the same as above but with the IN operator
SELECT * FROM employees WHERE first_name IN ('Eugene', 'Sheldon'); --better IF there ARE many VALUES TO choose FROM  


--ORDER BY-----------------

SELECT * FROM roles ORDER BY role_salary; --BY defualt, it orders BY increasing ORDER 

--we can specify "desc" for descending ORDER 
SELECT * FROM employees ORDER BY first_name DESC;


--FUNCTIONS----------------

--Scaler functions can take in up to one value, and they return one value

SELECT now(); --RETURNS CURRENT date/time
SELECT upper('this string will be returned in uppercase');

--Aggregate function can take multiple values, and they return one value.
SELECT avg(role_salary) FROM roles;
SELECT sum(role_salary) FROM roles;
SELECT count(first_name) FROM employees;


--GROUP BY will merge rows together based on matching column VALUES 
SELECT count(*) FROM roles GROUP BY role_salary;

--HAVING is like a where clause, but it can only be used after a GROUP BY. WHERE will not owkr after a GROUP BY 
SELECT count(*) FROM employees GROUP BY last_name HAVING last_name = 'Tentacle';

--This is because the WHERE clause only works after a selection from the tables
--WHERE does not work on values returned from aggregate functions.



--UPDATE-----------
--we can use the UPDATE command to change values in our tables

--let's say want to chnage an employees last name (maybe they got married or sumn)
UPDATE employees SET last_name = 'Plankton' WHERE first_name = 'Sheldon';
--NOTE:the where clause is important here,otherwise everybody's last name would CHANGE 


--DELETE--------------------------

--We can use delete to delete records from a table. (I don't often do this, but sometimes it's necessary)

--trying to delete the marketing director role
DELETE FROM roles WHERE role_title = 'Marketing director';
--this delete works fine, since no employees are linked to marketing director role

--now, let's try to delete the manager role
DELETE FROM roles WHERE role_title = 'Manager';
--can't do it! There are employee records that are pointing to the manager records
--If you try to delete a record that is depended on by other records, PostgreSQL won't let you do it.

/* why can'tt we delete??
  
 This os just a built-in rule, to avoid what's known as "orphan records"
  "we can't have records that refer other records that don't exist"
  This is one way SQL enforces REFERENTIAL INTEGRITY
  
  In order for this delete to work, we would have had to say "ON DELETE CASCADE" in our foreign key column observe below: (not a real table we'll use)
  */

CREATE TABLE employees(
--other fields here (id, first/last name)
role_id_fk int REFERENCES roles(role_id) ON DELETE CASCADE --this ALSO works FOR ON UPDATE CASCADE
);

