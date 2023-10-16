package com.example.demo_testcase.Service;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_testcase.Repository.StudentRepository;
import com.example.demo_testcase.model.Student;
import com.example.demo_testcase.model.mapper.StudentMapper;

@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;

  public List<Student> findAll() {
    // List<Student> output = new ArrayList<>();
    // for (StudentEntity se : studentRepository.findAll()) {
    // output.add(StudentMapper.map(se));
    // }
    // return output;
    return studentRepository.findAll().stream()//
        .map(e -> StudentMapper.map(e))//
        .collect(Collectors.toList());
  }

  public String getStudentName() {
    return new Student("Mary", 30).getName();
  }

  // junit test test唔到，就應該group埋D野
  // app2

  public String getStudentName2(String name) {
    // if IAE
    if (name == null)
      throw new IllegalArgumentException();
    return this.getDB();// mock Mary
  }

  public String getDB() { // get from DB
    return new Student("John", 30).concat("Chan");
  }

}
