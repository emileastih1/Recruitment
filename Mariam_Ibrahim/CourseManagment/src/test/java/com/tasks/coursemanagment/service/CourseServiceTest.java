package com.tasks.coursemanagment.service;

import com.tasks.coursemanagment.CourseManagmentApplication;
import com.tasks.coursemanagment.model.dto.CourseDTO;
import com.tasks.coursemanagment.model.entity.Course;
import com.tasks.coursemanagment.model.mapper.CourseMapper;
import com.tasks.coursemanagment.model.mapper.CourseMapperImpl;
import com.tasks.coursemanagment.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

;import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes= {CourseManagmentApplication.class,CourseMapperImpl.class})
class CourseServiceTest {

    @Mock
    CourseRepository courseRepository;

    @Autowired
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
//        courseDTO.setDescription("6 steps");
//        courseDTO.setSteps(Stream.of("Learn how to break things up","Automate the hell of everything","Have fun")
//                .collect(Collectors.toSet()));
        when(courseRepository.save(any(Course.class)))
                .thenReturn(new Course());
        Course newCourse = courseService.create(courseDTO);

        assertThat(newCourse.getName()).isEqualTo(courseDTO.getName());

    }

    @Test
    void when_update_course_should_return_course() {
        Long id = 1l;
        CourseDTO courseDTO=new CourseDTO();
        courseDTO.setName("microservices");
        courseDTO.setDescription("6 steps");
//        courseDTO.setSteps(Stream.of("Learn how to break things up","Automate the hell of everything","Have fun")
//                .collect(Collectors.toSet()));

        when(courseRepository.findById(id))
                .thenReturn(Optional.of(new Course( "microservices","7 steps", Collections.emptySet(),Collections.emptySet())));

        when(courseRepository.save(any(Course.class)))
                .thenReturn(new Course());

        CourseDTO updatedCourse = courseService.update(id, courseDTO);
        assertThat(updatedCourse.getId()).isEqualTo(id);

    }

    @TestConfiguration
    @SpringBootTest(classes= CourseMapperImpl.class)
    class CourseMapperTest{

    }
}