package com.tasks.coursemanagment.model.mapper;

import com.tasks.coursemanagment.common.model.mapper.BaseMapper;
import com.tasks.coursemanagment.model.dto.StudentDTO;
import com.tasks.coursemanagment.model.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper<Student, StudentDTO> {
}
