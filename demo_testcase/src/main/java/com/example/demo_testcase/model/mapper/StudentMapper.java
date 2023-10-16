package com.example.demo_testcase.model.mapper;

import com.example.demo_testcase.Entity.StudentEntity;
import com.example.demo_testcase.model.Student;

public class StudentMapper {
  
  public static Student map(StudentEntity studentEntity) {
    return Student.builder()//
        .name(studentEntity.getName())//
        .age(studentEntity.getAge())//
        .build();

  }
}
