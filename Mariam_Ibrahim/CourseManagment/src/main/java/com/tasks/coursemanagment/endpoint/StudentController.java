package com.tasks.coursemanagment.endpoint;

import com.tasks.coursemanagment.common.service.BaseController;
import com.tasks.coursemanagment.model.dto.StudentDTO;
import com.tasks.coursemanagment.model.entity.Student;
import com.tasks.coursemanagment.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController<Student, StudentDTO, StudentService> {

    public StudentController(StudentService service) {
        super(service);
    }

    @Override
    protected void validateCreateBusiness(StudentDTO dto) {
    if(!service.studentExists(dto.getName()))
        throw new RuntimeException("This Student already exists");
    }
}
