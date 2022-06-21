package com.tasks.coursemanagment.model.dto;

import com.tasks.coursemanagment.common.model.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor
public class StudentDTO extends BaseDTO {

    private String name;

    private LocalDate birthOfDate;

}
