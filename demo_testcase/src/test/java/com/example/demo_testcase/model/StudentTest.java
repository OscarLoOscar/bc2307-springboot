package com.example.demo_testcase.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class StudentTest {
  
  @Test
  void testSetterGetter() {
    // 唔洗試埋constructor
    // step 1 : when
    Student student = new Student("John", 30);
    // step 2 : test getter
    String name = student.getName();
    // step 3 : assert
    assertEquals("John", name);

    // test setter
    student.setName("Mary");
    // assert
    assertEquals("Mary", student.getName());

  }

  @Test
  void testConcat() {
    // when
    String lastName = "Wong";
    Student student = new Student("John", 40);
    // test
    String result = student.concat(lastName);
    // assert
    assertEquals("John Wong", result);
  }

  @Test
  void testCalculateScore() {
    // when
    int score = 20;
    Student student = new Student("John", 40);
    // test
    int result = student.calculateScore(score);
    // assert
    assertEquals(20, result);

    // Case 2
    student.setAge(17);
    int result2 = student.calculateScore(score);
    assertEquals(25, result2);

        // Case 3
    student.setAge(65);
    int result3 = student.calculateScore(score);
    assertEquals(30, result3);

    // Case 4
    student.setAge(64);
    int result4 = student.calculateScore(score);
    assertEquals(20, result4);

  }
}
