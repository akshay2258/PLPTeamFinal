DROP TABLE program_offered;
create table program_offered(
Program_Name varchar2(5) Constraint program_offered_pk primary key, 
description varchar2(20), 
applicant_eligibility varchar2(40) , 
duration number, 
degree_certificate_offered varchar2(10)
);


insert into PROGRAM_OFFERED values('Btech','Engineering','Above 80% in SSC',4,'UG Certi');
insert into PROGRAM_OFFERED values('Mtech','Engineering','Above 80% in Btech',2,'PG Certi');
insert into PROGRAM_OFFERED values('BBA','Management','SSC Passed with above 80% in PCM',3,'UG Certi');
insert into PROGRAM_OFFERED values('MBA','Management','Above 80% in UG Course',2,'PG Certi');
insert into PROGRAM_OFFERED values('B.COM','Commerece','Above 80% in SSC',3,'UG Certi');
insert into PROGRAM_OFFERED values('M.COM','Engineering Course','Above 80% in B.Com',2,'PG Certi');
insert into PROGRAM_OFFERED values('BSc','Science','Above 80% in SSC',3,'UG Certi');
insert into PROGRAM_OFFERED values('MSc','Science','Above 80% in BSc',2,'PG Certi');
insert into PROGRAM_OFFERED values('MBBS','Medical','Above 80% in SSC',5,'PG Certi');
insert into PROGRAM_OFFERED values('BDS','Dental Science','Above 80% in SSC',3,'UG Certi');
insert into PROGRAM_OFFERED values('BA','Arts','Above 80% in SSC',3,'UG Certi');
insert into PROGRAM_OFFERED values('MA','Arts','Above 80% in BA',2,'PG Certi');
insert into PROGRAM_OFFERED values('PHD','Doctrate','Above 80% in Bachelor Degree',4,'PHD Certi');

select * from PROGRAM_OFFERED;


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
insert into PROGRAM_SCHEDULED values('E101','Btech','Mumbai','02-Apr-2018','02-Apr-2022',5);
insert into PROGRAM_SCHEDULED values('E201','Btech','Banglore','02-Apr-2018','02-Apr-2022',5);
insert into PROGRAM_SCHEDULED values('E301','Btech','Pune','02-Apr-2018','02-Apr-2022',5);
insert into PROGRAM_SCHEDULED values('E401','Btech','Delhi','02-Apr-2018','02-Apr-2022',5);

insert into PROGRAM_SCHEDULED values('E102','Mtech','Mumbai','02-Apr-2018','02-Apr-2020',5);
insert into PROGRAM_SCHEDULED values('E202','Mtech','Banglore','02-Apr-2018','02-Apr-2020',5);
insert into PROGRAM_SCHEDULED values('E302','Mtech','Pune','02-Apr-2018','02-Apr-2020',5);
insert into PROGRAM_SCHEDULED values('E402','Mtech','Delhi','02-Apr-2018','02-Apr-2020',5);

insert into PROGRAM_SCHEDULED values('E1','PHD','Mumbai','02-Apr-2018','02-Apr-2022',4);
insert into PROGRAM_SCHEDULED values('E2','PHD','Banglore','02-Apr-2018','02-Apr-2022',4);
insert into PROGRAM_SCHEDULED values('E3','PHD','Pune','02-Apr-2018','02-Apr-2022',4);
insert into PROGRAM_SCHEDULED values('E4','PHD','Delhi','02-Apr-2018','02-Apr-2022',4);

insert into PROGRAM_SCHEDULED values('MG101','BBA','Mumbai','02-May-2018','02-May-2021',5);
insert into PROGRAM_SCHEDULED values('MG201','BBA','Banglore','02-May-2018','02-May-2021',5);
insert into PROGRAM_SCHEDULED values('MG301','BBA','Pune','02-May-2018','02-May-2021',5);
insert into PROGRAM_SCHEDULED values('MG401','BBA','Delhi','02-May-2018','02-May-2021',5);

insert into PROGRAM_SCHEDULED values('MG102','MBA','Mumbai','02-May-2018','02-May-2020',5);
insert into PROGRAM_SCHEDULED values('MG202','MBA','Banglore','02-May-2018','02-May-2020',5);
insert into PROGRAM_SCHEDULED values('MG302','MBA','Pune','02-May-2018','02-May-2020',5);
insert into PROGRAM_SCHEDULED values('MG402','MBA','Delhi','02-May-2018','02-May-2020',5);

insert into PROGRAM_SCHEDULED values('MG1','PHD','Mumbai','02-May-2018','02-May-2022',4);
insert into PROGRAM_SCHEDULED values('MG2','PHD','Banglore','02-May-2018','02-May-2022',4);
insert into PROGRAM_SCHEDULED values('MG3','PHD','Pune','02-May-2018','02-May-2022',4);
insert into PROGRAM_SCHEDULED values('MG4','PHD','Delhi','02-May-2018','02-May-2022',4);

insert into PROGRAM_SCHEDULED values('CM101','B.COM','Mumbai','02-Jun-2018','02-Jun-2021',5);
insert into PROGRAM_SCHEDULED values('CM201','B.COM','Banglore','02-Jun-2018','02-Jun-2021',5);
insert into PROGRAM_SCHEDULED values('CM301','B.COM','Pune','02-Jun-2018','02-Jun-2021',5);
insert into PROGRAM_SCHEDULED values('CM401','B.COM','Delhi','02-Jun-2018','02-Jun-2021',5);

insert into PROGRAM_SCHEDULED values('CM102','M.COM','Mumbai','02-Jun-2018','02-Jun-2020',5);
insert into PROGRAM_SCHEDULED values('CM202','M.COM','Banglore','02-Jun-2018','02-Jun-2020',5);
insert into PROGRAM_SCHEDULED values('CM302','M.COM','Pune','02-Jun-2018','02-Jun-2020',5);
insert into PROGRAM_SCHEDULED values('CM402','M.COM','Delhi','02-Jun-2018','02-Jun-2020',5);

insert into PROGRAM_SCHEDULED values('CM1','PHD','Mumbai','02-Jun-2018','02-Jun-2022',4);
insert into PROGRAM_SCHEDULED values('CM2','PHD','Banglore','02-Jun-2018','02-Jun-2022',4);
insert into PROGRAM_SCHEDULED values('CM3','PHD','Pune','02-Jun-2018','02-Jun-2022',4);
insert into PROGRAM_SCHEDULED values('CM4','PHD','Delhi','02-Jun-2018','02-Jun-2022',4);

insert into PROGRAM_SCHEDULED values('SC101','BSc','Mumbai','02-Apr-2018','02-Apr-2021',5);
insert into PROGRAM_SCHEDULED values('SC201','BSc','Banglore','02-Apr-2018','02-Apr-2021',5);
insert into PROGRAM_SCHEDULED values('SC301','BSc','Pune','02-Apr-2018','02-Apr-2021',5);
insert into PROGRAM_SCHEDULED values('SC401','BSc','Delhi','02-Apr-2018','02-Apr-2021',5);

insert into PROGRAM_SCHEDULED values('SC102','MSc','Mumbai','02-Apr-2018','02-Apr-2020',5);
insert into PROGRAM_SCHEDULED values('SC202','MSc','Banglore','02-Apr-2018','02-Apr-2020',5);
insert into PROGRAM_SCHEDULED values('SC302','MSc','Pune','02-Apr-2018','02-Apr-2020',5);
insert into PROGRAM_SCHEDULED values('SC402','MSc','Delhi','02-Apr-2018','02-Apr-2020',5);

insert into PROGRAM_SCHEDULED values('SC1','PHD','Mumbai','02-Apr-2018','02-Apr-2022',4);
insert into PROGRAM_SCHEDULED values('SC2','PHD','Banglore','02-Apr-2018','02-Apr-2022',4);
insert into PROGRAM_SCHEDULED values('SC3','PHD','Pune','02-Apr-2018','02-Apr-2022',4);
insert into PROGRAM_SCHEDULED values('SC4','PHD','Delhi','02-Apr-2018','02-Apr-2022',4);

insert into PROGRAM_SCHEDULED values('AR101','BA','Mumbai','02-May-2018','02-May-2021',5);
insert into PROGRAM_SCHEDULED values('AR201','BA','Banglore','02-May-2018','02-May-2021',5);
insert into PROGRAM_SCHEDULED values('AR301','BA','Pune','02-May-2018','02-May-2021',5);
insert into PROGRAM_SCHEDULED values('AR401','BA','Delhi','02-May-2018','02-May-2021',5);

insert into PROGRAM_SCHEDULED values('AR102','MA','Mumbai','02-May-2018','02-May-2020',5);
insert into PROGRAM_SCHEDULED values('AR202','MA','Banglore','02-May-2018','02-May-2020',5);
insert into PROGRAM_SCHEDULED values('AR302','MA','Pune','02-May-2018','02-May-2020',5);
insert into PROGRAM_SCHEDULED values('AR402','MA','Delhi','02-May-2018','02-May-2020',5);

insert into PROGRAM_SCHEDULED values('AR1','PHD','Mumbai','02-May-2018','02-May-2022',4);
insert into PROGRAM_SCHEDULED values('AR2','PHD','Banglore','02-May-2018','02-May-2022',4);
insert into PROGRAM_SCHEDULED values('AR3','PHD','Pune','02-May-2018','02-May-2022',4);
insert into PROGRAM_SCHEDULED values('AR4','PHD','Delhi','02-May-2018','02-May-2022',4);

insert into PROGRAM_SCHEDULED values('DS101','BDS','Mumbai','02-Jun-2018','02-Jun-2021',5);
insert into PROGRAM_SCHEDULED values('DS201','BDS','Banglore','02-Jun-2018','02-Jun-2021',5);
insert into PROGRAM_SCHEDULED values('DS301','BDS','Pune','02-Jun-2018','02-Jun-2021',5);
insert into PROGRAM_SCHEDULED values('DS401','BDS','Delhi','02-Jun-2018','02-Jun-2021',5);

insert into PROGRAM_SCHEDULED values('MD102','MA','Mumbai','02-Jun-2018','02-Jun-2020',5);
insert into PROGRAM_SCHEDULED values('MD202','MA','Banglore','02-Jun-2018','02-Jun-2020',5);
insert into PROGRAM_SCHEDULED values('MD302','MA','Pune','02-Jun-2018','02-Jun-2020',5);
insert into PROGRAM_SCHEDULED values('MD402','MA','Delhi','02-Jun-2018','02-Jun-2020',5);

insert into PROGRAM_SCHEDULED values('MD1','PHD','Mumbai','02-Jun-2018','02-Jun-2022',4);
insert into PROGRAM_SCHEDULED values('MD2','PHD','Banglore','02-Jun-2018','02-Jun-2022',4);
insert into PROGRAM_SCHEDULED values('MD3','PHD','Pune','02-Jun-2018','02-Jun-2022',4);
insert into PROGRAM_SCHEDULED values('MD4','PHD','Delhi','02-Jun-2018','02-Jun-2022',4);


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
DROP TABLE PROGRAM_SCHEDULED cascade constraints;
DROP TABLE applicants cascade constraints;
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