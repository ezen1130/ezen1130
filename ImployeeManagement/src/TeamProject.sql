CREATE TABLE employee2(
id varchar2(10),
name varchar2(15),
position varchar2(15)
)

alter table employee2 add constraint pk_employee_id primary key(id)

CREATE TABLE attendee(
id varchar2(10),
name varchar2(15),
intime date,
exittime date
)

alter table attendee add constraint pk_ettendee_id primary key(id)
alter table attendee add constraint fk_attendee_id foreign key(id) references employee2(id)

SELECT * FROM employee2
SELECT * FROM attendee