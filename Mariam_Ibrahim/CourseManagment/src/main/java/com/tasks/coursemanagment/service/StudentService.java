package com.tasks.coursemanagment.service;

import com.tasks.coursemanagment.common.service.BaseService;
import com.tasks.coursemanagment.model.dto.StudentDTO;
import com.tasks.coursemanagment.model.entity.Student;
import com.tasks.coursemanagment.model.mapper.StudentMapper;
import com.tasks.coursemanagment.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService<Student, StudentDTO, StudentRepository> {

    public StudentService(StudentMapper mapper, StudentRepository repository ) {
        super(mapper, repository);
    }
public boolean studentExists(String name){
        return repository.existsByName(name);

}
}
