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


UPDATE roles SET role_salary = 500000 WHERE role_title = 'Manager';

