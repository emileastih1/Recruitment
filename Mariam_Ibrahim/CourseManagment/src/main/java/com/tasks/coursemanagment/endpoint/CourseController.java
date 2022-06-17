package com.tasks.coursemanagment.endpoint;

import com.tasks.coursemanagment.common.service.BaseController;
import com.tasks.coursemanagment.model.dto.CourseDTO;
import com.tasks.coursemanagment.model.entity.Course;
import com.tasks.coursemanagment.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController<Course, CourseDTO, CourseService> {
    public CourseController(CourseService service) {
        super(service);
    }

    @Override
    protected void validateCreateBusiness(CourseDTO dto) {
        if (service.courseExists(dto.getName()))
            throw new RuntimeException(("Course Already Exists"));
    }
}
