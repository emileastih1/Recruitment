package com.tasks.coursemanagment.model.dto;

import com.tasks.coursemanagment.common.model.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter @Getter
@NoArgsConstructor
public class CourseDTO extends BaseDTO {

    private String name;
    private String description;
    private Set<String> steps;
}
