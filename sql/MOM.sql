
create sequence emp_id 
start with 100 increment by 1
no cache no cycle;

create table employees(emp_id int, emp_name varchar2(20), emp_email varchar2(20), emp_pass varchar2(20), emp_desg varchar2(20) , dept_id int , emp_status number(1) , emp_startdate date);
