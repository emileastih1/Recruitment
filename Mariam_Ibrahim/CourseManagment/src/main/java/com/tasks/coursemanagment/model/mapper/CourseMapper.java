package com.tasks.coursemanagment.model.mapper;

import com.tasks.coursemanagment.common.model.mapper.BaseMapper;
import com.tasks.coursemanagment.model.dto.CourseDTO;
import com.tasks.coursemanagment.model.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper extends BaseMapper<Course, CourseDTO> {
}
