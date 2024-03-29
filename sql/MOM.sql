--departments table created

create table departments(dept_id int primary key,dept_name varchar2(30));


--employee table created

create table employees(emp_id int primary key, emp_name varchar2(20), emp_email varchar2(20), emp_pass varchar2(20), emp_desg varchar2(20) , dept_id int , emp_status number(1) , emp_startdate date,emp_enddate date,foreign key(dept_id) references departments(dept_id));

--sequence created for emp_id

create sequence emp_id start with 100 increment by 1 nocache nocycle;


--MoM table created(data type CLOB is used for mom_pointsdiscussed)

create table mom(mom_id int primary key, mom_subject varchar2(100), mom_startdate date,mom_enddate date, mom_creatorid int,mom_pointsdiscussed clob,mom_decisiontaken clob,mom_openitems clob, foreign key(mom_creatorid) references employees(emp_id)); 

--sequence created for MoM_id

create sequence mom_id start with 1 increment by 1 nocache nocycle;

--participants table created

create table participants( emp_id int,mom_id int, attendence number(1), foreign key(mom_id) references mom(mom_id),foreign key(emp_id) references employees(emp_id));

--action table created

create table action(action_id int,action_name varchar2(30),mom_id int,action_due Date,emp_id int default 0,primary key(action_id),foreign key(mom_id) references mom(mom_id));

--sequence created for action_id

create sequence action_id start with 1 increment by 1 nocache nocycle;

--action status table created

create table action_status(action_id int, current_status varchar2(20),open timestamp,assigned timestamp,wip timestamp,ready_for_closure timestamp,closed timestamp,withdrawn timestamp,foreign key(action_id) references action(action_id));

--inseriting values for database
insert into departments values(1,'hr');

--1 row created.

insert into departments values(2,'Sales');

--1 row created.

insert into departments values(3,'SAP');

--1 row created.

insert into departments values(4,'Testing');

--1 row created.

insert into departments values(5,'Recrutement');

--1 row created.
