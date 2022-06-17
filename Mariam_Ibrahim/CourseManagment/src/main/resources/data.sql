CREATE TABLE student (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  deleted BOOLEAN NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(150) ,
  name VARCHAR(250) NOT NULL,
  birth_of_date TIMESTAMP
);
CREATE TABLE course (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  deleted BOOLEAN NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(150) ,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  steps VARCHAR(100) ARRAY
);

CREATE TABLE course_student (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  course_id BIGINT,
  student_id BIGINT,
  constraint courseFK foreign key (course_id)
          references course (id)
  ,constraint studentFK foreign key (student_id)
            references student (id)

);

insert into student (id,deleted,created_at,created_by,name,birth_of_date)
values
 (1,false,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Mariam Ibrahim Abdulkader',null),
 (2,false,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Emile ASTIH',null),
 (3,false,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Mariam Gouda',null);


insert into course (id,deleted,created_at,created_by,name,description)
values
 (1,false,CURRENT_TIMESTAMP(),'eng.nobia.86@gmail.com','Microservices','10 steps');
 --,['Learn how to break things up','Automate the hell of everything','Have fun'])

 insert into course_student (id,course_id,student_id)
 values
  (1,1,1),(2,1,2),(3,1,3);
