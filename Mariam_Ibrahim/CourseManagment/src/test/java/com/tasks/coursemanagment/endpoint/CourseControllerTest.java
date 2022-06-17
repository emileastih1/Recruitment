package com.tasks.coursemanagment.endpoint;

import com.tasks.coursemanagment.model.entity.Course;
import com.tasks.coursemanagment.model.mapper.CourseMapper;
import com.tasks.coursemanagment.repository.CourseRepository;
import com.tasks.coursemanagment.service.CourseService;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment =
        SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@TestPropertySource(
        locations = "classpath:application-integrationtest.yml")//in case test properties - recently not needed
@AutoConfigureMockMvc
public class CourseControllerTest {
    @MockBean
    CourseService courseService;

    @Test
    void when_send_id_update_and_return_course(){

    }


}