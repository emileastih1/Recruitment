package com.tasks.coursemanagment.repository;

import com.tasks.coursemanagment.common.repository.BaseRepository;
import com.tasks.coursemanagment.model.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<Student> {
    boolean existsByName(String name);
}
