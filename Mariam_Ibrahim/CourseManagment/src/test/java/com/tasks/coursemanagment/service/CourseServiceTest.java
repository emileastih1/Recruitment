package com.tasks.coursemanagment.service;

import com.tasks.coursemanagment.model.dto.CourseDTO;
import com.tasks.coursemanagment.model.entity.Course;
import com.tasks.coursemanagment.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

;import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CourseServiceTest {

    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CourseService courseService;

    @Test
    void when_course_exists_return_true() {
        CourseDTO courseDTO=new CourseDTO();
        courseDTO.setName("microservices");
         when(courseRepository.existsByName(courseDTO.getName()))
                 .thenReturn(true);
        boolean courseExists = courseService.courseExists(courseDTO.getName());
        assertThat(courseExists).isTrue();

    }

    @Test
    void when_save_course_should_return_course() {
        CourseDTO courseDTO=new CourseDTO();
        courseDTO.setName("microservices");
        courseDTO.setDescription("6 steps");
        courseDTO.setSteps(Stream.of("Learn how to break things up","Automate the hell of everything","Have fun")
                .collect(Collectors.toSet()));
        when(courseRepository.save(any(Course.class)))
                .thenReturn(new Course());
        Course newCourse = courseService.create(courseDTO);

        assertThat(newCourse.getName()).isEqualTo(courseDTO.getName());

    }

    @Test
    void when_update_course_should_return_course() {
        Long id = 2l;
        CourseDTO courseDTO=new CourseDTO();
        courseDTO.setName("microservices");
        courseDTO.setDescription("6 steps");
        courseDTO.setSteps(Stream.of("Learn how to break things up","Automate the hell of everything","Have fun")
                .collect(Collectors.toSet()));

        when(courseRepository.save(any(Course.class)))
                .thenReturn(courseRepository.findById(id).get());

        CourseDTO updatedCourse = courseService.update(id, courseDTO);
        assertThat(updatedCourse.getId()).isEqualTo(id);

    }
}