--To create a new schema (which we'll do for every individual database/demo/project):
-- right click the schemas folder -> create a new schema -> give it a name
--right click the new schema -> sql editor -> new sql script

--Data definition language (DDL): CREATE, ALTER, TRUNCATE, DROP
--DDL is any SQL command that relates to the STRUCTURE of your database and its table.

CREATE TABLE users(
	username TEXT
    --username is the name of a column (attributes) in the users table.
    --text is the datatype. So username will be stored in text format. (like a java string)
);


--we can view this table by right clicking the schema -> view diagram
--don't forget to right click -> refresh the schema for change to populate

--OH NO!! I forgot to add the user's age to the table! I can ALTER the table with the ALTER command
ALTER TABLE users ADD user_age int;

--I won't run the two commands below (there's no data and I want the table to stay up )

--we can use the TRUNCATE to wipe all the data from a table
TRUNCATE TABLE users;

--we can use DROP to delete a table and all of its data
DROP TABLE users;

--DATA TYPES

--O'm going to make a horribly designed table to list out some data types
--Why is this table bad? No primary key, not notmalized, bad column names, we'll never make another table like this 

CREATE TABLE datatypes(
 
	small_number int2, --2bytes. used FOR smaller numbers (like a short in java)
	normal_number int, --4 bytes, most commonly used int TYPE
	big_number int8, --8 bytes IN SIZE, normally used FOR very LARGE numbers (like a long in java)
	standard_decimal decimal(10, 2), --2 parameters (total # of digits, total # of decimal places)
	--So this decimal will be 8 integers and 2 decimal places
	
	"boolean" boolean, --double quotes let you use keywords etc. AS COLUMN VALUES
	
	fixed_length_text char(2), --TEXT field that can ONLY HOLD the amount OF CHARACTERS given (2 in this case)
	variable_lenght_text varchar(15), --TEXT field that can HOLD up TO the amount OF CHARACTERS given
	unlimited_length_text TEXT, --unlimited length, I use this one primarily
	
	"date" date --lets you INPUT dates IN YYYY-MM-DD format
	--can be tricky to convert from Java Date objects.... sometimes I prefer just a text-based date in the db 2034/54/23
	
	--because no other columns come after the date column, we don't put a comma
	   
);