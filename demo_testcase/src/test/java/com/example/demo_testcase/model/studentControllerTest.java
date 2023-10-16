package com.example.demo_testcase.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.demo_testcase.Controller.StudentController;
import com.example.demo_testcase.Service.StudentService;

@SpringBootTest
public class studentControllerTest {

  @MockBean // 成舊假,可以比我when
  private StudentService studentService;

  @Autowired
  private StudentController studentController;

  @Test
  void testService() {
    // 應該直接mvc
    // when
    Mockito.when(studentService.getStudentName2("Peter"))
        .thenReturn("Jenny Lee");
    // test
    String result = studentController.getStudentName2("Peter");
    // assert
    assertEquals("Jenny Lee", result);

  }
}
