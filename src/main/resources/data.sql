insert into course(id,name,created_date,last_updated_date) values (1001,'JAVA', sysdate(), sysdate());
insert into course(id,name,created_date,last_updated_date) values (1002,'C++', sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date) values (1003,'DS', sysdate(), sysdate());


insert into passport(id,number) values (3001,'E123');
insert into passport(id,number) values (3002,'E456');
insert into passport(id,number) values (3003,'E789');

insert into student(id,name,passport_id) values (2001,'Akshay',3001);
insert into student(id,name,passport_id) values (2002,'Sagar',3002);
insert into student(id,name,passport_id) values (2003,'Vinit',3003);



insert into review(id,description,rating,course_id) values (4001,'good',4,1001);
insert into review(id,description,rating,course_id) values (4002,'great',5,1001);
insert into review(id,description,rating,course_id) values (4003,'cool',4,1002);


insert into student_course(student_id,course_id) values(2001,1001);
insert into student_course(student_id,course_id) values(2001,1002);
insert into student_course(student_id,course_id) values(2001,1003);
insert into student_course(student_id,course_id) values(2002,1003);