create schema employee;
use employee;
drop table department;
drop table employee;
drop table address;
 create table address(
`add_id` int  NOT NULL AUTO_INCREMENT,
`street` varchar(30) ,
 `city` varchar(30) ,
 `state` varchar(30),
 `zipcode` varchar(15) ,
 PRIMARY KEY (`add_id`)
 );
 create table employee (
emp_id  INT  NOT NULL AUTO_INCREMENT,
emp_name varchar(30) ,
 mobile_number varchar(15) ,
 dob varchar(30),
 address INT  NOT NULL UNIQUE,
 PRIMARY KEY (`emp_id`)
 );
 Alter table employee 
 ADD CONSTRAINT FK_address_Employee FOREIGN KEY(address)  
    REFERENCES address(add_id);
  create table department(
`dept_id` int  NOT NULL AUTO_INCREMENT,
`department_name` varchar(30) ,
 `company_name` varchar(30) ,
 employee int ,
 PRIMARY KEY (`dept_id`),
 KEY FK_employee_dept(employee),
CONSTRAINT FK_employee_dept FOREIGN KEY (employee) REFERENCES employee (emp_id)
 );

INSERT INTO `employee`.`address` (`add_id`, `street`, `city`, `state`, `zipcode`) VALUES ('100', 'abc', 'skht', 'ap', '517644');
INSERT INTO `employee`.`employee` (`emp_id`, `emp_name`, `mobile_number`, `dob`, `address`) VALUES ('100', 'Navee', '1234567890', '12-09-1994', '100');
INSERT INTO `employee`.`department` (`dept_id`, `department_name`, `company_name`, `employee`) VALUES ('100', 'IT', 'Naveen', '100');


SELECT * FROM employee.employee;

SELECT * FROM employee.address;

SELECT * FROM employee.department;
