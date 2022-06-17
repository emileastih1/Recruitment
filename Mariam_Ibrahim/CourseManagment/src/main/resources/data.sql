CREATE TABLE student (
  id NUMBER AUTO_INCREMENT  PRIMARY KEY,
  deleted VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(150) ,
  name VARCHAR(250) NOT NULL,
  birth_of_date TIMESTAMP
);
CREATE TABLE course (
  id NUMBER AUTO_INCREMENT  PRIMARY KEY,
  deleted VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(150) ,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  steps VARCHAR(100) ARRAY
);
insert into student (id,created_at,created_by,name,birth_of_date)
values
 (1,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Mariam Ibrahim Abdulkader',null),
 (2,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Emile ASTIH',null),
 (3,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Mariam Gouda',null);


insert into course (id,created_at,created_by,name,description,steps)
values
 (1,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Microservices','10 steps',["Learn how to break things up","Automate the hell of everything","Have fun"]);

 insert into course_student (id,course_id,student_id)
 values
  (1,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Mariam Ibrahim Abdulkader',null),
  (2,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Emile ASTIH',null),
  (3,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Mariam Gouda',null);
