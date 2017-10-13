DROP TABLE program_offered;
create table program_offered(
Program_Name varchar2(5) Constraint program_offered_pk primary key, 
description varchar2(20), 
applicant_eligibility varchar2(40) , 
duration number, 
degree_certificate_offered varchar2(10)
);

delete from program_offered where Program_Name='Btech';
insert into PROGRAM_OFFERED values('Btech','Mechanical','SSC Passed',4,'UG Certi');
insert into PROGRAM_OFFERED values('BSc','Chemistry','SSC Passed',3,'UG Certi');
insert into PROGRAM_OFFERED values('MBA','HR','SSC Passed',2,'PG Certi');
insert into PROGRAM_OFFERED values('BCom','Accounts','SSC Passed',4,'UG Certi');
insert into PROGRAM_OFFERED values('BA','History','SSC Passed',3,'UG Certi');
insert into PROGRAM_OFFERED values('BDS','Dental','SSC Passed',4,'UG Certi');
DROP TABLE program_Scheduled;
create table program_Scheduled ( 
		Scheduled_program_id varchar2(5) Constraint program_Scheduled_pk primary key, 
		Program_Name Constraint program_Scheduled_fk references program_offered(Program_Name) ON DELETE CASCADE, 
		Location varchar2(10), 
		start_date date, 
		end_date date, 
		sessions_per_week number
);

insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'Btech','Mumbai','02-Apr-2018','02-Apr-2022',5);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'Btech','Mumbai','02-Sep-2018','02-Sep-2022',5);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'BSc','Bangalore','02-May-2018','02-May-2022',5);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'BSc','Bangalore','02-Oct-2018','12-Oct-2022',5);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'MBA','Pune','02-Jun-2018','02-Jun-2022',5);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'MBA','Pune','02-Nov-2018','02-Nov-2022',5);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'BCom','Delhi','02-Jul-2018','02-Jul-2022',5);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'BCom','Delhi','02-Dec-2018','02-Dec-2022',5);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'BA','Orissa','02-Aug-2018','02-Aug-2022',4);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'BA','Orissa','02-Jan-2018','02-Jan-2022',4);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'BDS','Kolkata','12-Jul-2018','12-Jul-2022',5);
insert into PROGRAM_SCHEDULED values(program_sch_id_seq.NEXTVAL,'BDS','Kolkata','12-Feb-2018','02-Feb-2022',5);
insert into PROGRAM_SCHEDULED values('1001','Btech','mumbai','02-FEB-2017','01-FEB-2021',5);
select * from PROGRAM_SCHEDULED;
DROP TABLE PROGRAM_SCHEDULED;
DROP TABLE applicants;

create table applicants( 
	Application_id number  Constraint applicants_pk primary key,
	full_name varchar2(20),
	date_of_birth date,
	highest_qualification varchar2(10),
	marks_obtained number,
	goals varchar2(20), 
	email_id varchar2(20) unique, 
	Scheduled_program_id  Constraint applicants_Fk references program_Scheduled(Scheduled_program_id) ON DELETE CASCADE,
	status varchar2(10) default 'applied' CONSTRAINT check_const_status check(status IN('applied','accepted', 'rejected','confirmed' )),
	Date_Of_Interview date 
);

select * from applicants;
DROP TABLE participants;
create table participants(
Roll_no varchar2(5) Constraint participants_Pk primary key, 
email_id varchar2(20) Constraint participants_check unique, 
Application_id Constraint participants_Fk references applicants(Application_id) ON DELETE CASCADE, 
Scheduled_program_id varchar2(5)
);

drop table users;
create table users (
login_id varchar2(5)  Constraint users_Pk primary key, 
password varchar2(10),
role varchar2(5) Constraint users_check check (role IN ('mac','admin'))
);

drop sequence application_id_seq;
create sequence application_id_seq
start with 20000
increment by 1;

create sequence program_sch_id_seq start with 1001;

create sequence program_id_seq
start with 1000
increment by 1;

create sequence roll_no_seq
start with 13000
increment by 1;


insert into users values('akp11','akp11','mac');
insert into users values('akh12','akh12','mac');
insert into users values('sat13','sat13','mac');
insert into users values('abh11','abh11','admin');
insert into users values('rah12','rah12','admin');
insert into users values('ros13','ros13','admin');
insert into users values('vip14','vip14','admin');