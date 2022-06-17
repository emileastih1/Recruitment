package com.tasks.coursemanagment.common.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter @Getter
@NoArgsConstructor
public class BaseDTO {
    private Long id;

    private boolean deleted;

    private LocalDateTime createdAt;

    private String created_by;
}
