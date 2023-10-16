package com.example.demo_testcase.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo_testcase.Controller.StudentController;
import com.example.demo_testcase.Service.StudentService;
import com.example.demo_testcase.model.Student;

// @ExtendWith(MockitoExtension.class)
@SpringBootTest//真enviorment
public class StudentServiceTest {

  @Spy // 要真bean。mock走部分功能，similar to @Autowird, but some method can be mocked 
  StudentService studentService;
  // @mock只能一對一，@Spy拎晒全部真野，mock走部分野。所以先 .when
  @InjectMocks
  StudentController studentController;

  // @mockMVC for restfulApi
  // Controller入口 @MockBean
  // MVC 試Json
  @Test
  void testGetDB() {
    //一個都唔mock，直接由Spy->Autowird
    // when
    Mockito.when(studentService.getDB()).thenReturn(new Student("Mary Lau", 30).getName());
    // test
    String result = studentService.getStudentName2(" ");//test name == null ? 
    // assert
    assertEquals("Mary Lau", result);
    //Test and Assert
    assertThrows(IllegalArgumentException.class,
        () -> studentController.getStudentName2(null));
  }
  //假設getDB(),set getDB() will return new Student("Mary Lau", 30).getName()
  //getStudentName2(" "),由getStudentName2() 黎試 為左試到getDB() , skip name == null,為左試到getDB()


  // myself version
  @Test
  void testgetStudentName2() {
    // when
    // // Arrange (Mock the behavior of the service method)
    String expectedName = new Student("Mary", 30).getName();
    Mockito.when(this.studentService.getDB()).thenReturn(expectedName);
    // test
    // Act and Assert
    // Test with a valid name
    String validName = new Student("John", 40).getName();

    // Mock the behavior of the service method to return a valid result
    Mockito.when(studentService.getDB()).thenReturn("John Chan");

    String result = studentController.getStudentName2(validName);
    assertEquals("John Chan", result);
    // assert
    // Test with a null name, expecting an IllegalArgumentException
    assertThrows(IllegalArgumentException.class,
        () -> studentController.getStudentName2(null));



  }
}
