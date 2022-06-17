package com.tasks.coursemanagment.repository;

import com.tasks.coursemanagment.common.repository.BaseRepository;
import com.tasks.coursemanagment.model.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends BaseRepository<Course> {
    boolean existsByName(String name);
}
