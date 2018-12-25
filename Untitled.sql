create schema employee;
use employee;
drop table employee;
create table employee (
'emp_id' INT  NOT NULL AUTO_INCREMENT,
'emp_name' varchar(30) ,
 'mobile_number' varchar(15) ,
 'dob`' varchar(30),
 'address' INT  UNIQUE FOREIGN KEY REFERENCES address(add_id),
   'department' INT FOREIGN KEY REFERENCES department(dept_id),
 PRIMARY KEY (`emp_id`)
 );
 create table address(
`add_id` int  NOT NULL AUTO_INCREMENT,
`street` varchar(30) ,
 `city` varchar(30) ,
 `state` varchar(30),
 `zipcode` varchar(15) ,
 PRIMARY KEY (`add_id`)
 );
  create table department(
`dept_id` int  NOT NULL AUTO_INCREMENT,
`department_name` varchar(30) ,
 `company_number` varchar(30) ,
 PRIMARY KEY (`dept_id`)
 );
SELECT * FROM employee.employee;