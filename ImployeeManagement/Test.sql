CREATE TABLE employee(
id varchar2(10),
name varchar2(15),
position varchar2(15)
)

alter table employee add constraint pk_employee_id primary key(id)

select *from employee

CREATE TABLE attendee(
id varchar2(10),
name varchar2(15),
intime varchar2(15),
exittime varchar2(30)
)

alter table attendee add constraint pk_attendee_id primary key(id)
alter table attendee add constraint fk_attendee_id foreign key(id)
references employee(id)

drop table attendee

insert into  attendee (id, name, intime) values ('00000001','kim','2020-11-30') 
select *from attendee

commit