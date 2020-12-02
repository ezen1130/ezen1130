SELECT * FROM attendee

DELETE FROM attendee 


ALTER TABLE attendee ADD CONSTRAINT pk_attendee_id PRIMARY KEY(id)

SELECT * FROM employee

INSERT INTO employee VALUES ('m001', 'kim', 'd')

DROP TABLE attendee


CREATE TABLE attendee(
id VARCHAR2(10),
name VARCHAR2(15),
intime VARCHAR2(30),
exittime VARCHAR2(30)
)

SELECT * FROM ATTENDEE

DELETE FROM attendee

ALTER TABLE attendee ADD CONSTRAINT pk_attendee_id PRIMARY KEY(id)

ALTER TABLE attendee ADD CONSTRAINT fk_attendee_id FOREIGN KEY(id) REFERENCES employee(id)

ALTER TABLE attendee DROP PRIMARY KEY

SELECT * FROM employee WHERE name = 'kim'
