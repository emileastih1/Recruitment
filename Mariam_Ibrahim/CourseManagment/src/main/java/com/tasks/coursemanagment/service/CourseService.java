package com.tasks.coursemanagment.service;

import com.tasks.coursemanagment.common.service.BaseService;
import com.tasks.coursemanagment.model.dto.CourseDTO;
import com.tasks.coursemanagment.model.entity.Course;
import com.tasks.coursemanagment.model.mapper.CourseMapper;
import com.tasks.coursemanagment.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends BaseService<Course, CourseDTO, CourseRepository> {

    public CourseService(CourseMapper mapper, CourseRepository repository) {
        super(mapper, repository);
    }

    public boolean courseExists(String name) {
        return repository.existsByName(name);
    }
}
