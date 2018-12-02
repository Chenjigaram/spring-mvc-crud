create schema employee;
use employee;
create table employee(
`emp_id` varchar(30) NOT NULL,
`emp_name` varchar(30) ,
 `mobile_number` varchar(15) ,
 `dob` date,
 `address` varchar(30) ,
 PRIMARY KEY (`emp_id`)
 )
SELECT * FROM employee.employee;