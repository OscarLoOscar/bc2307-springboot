package com.example.demo_testcase.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo_testcase.Entity.StudentEntity;
import com.example.demo_testcase.Service.StudentService;
import com.example.demo_testcase.model.Student;

@Controller
@ResponseBody
@RequestMapping("/v1")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/student/{name}")
  public String getStudentName2(@PathVariable String name) {
    return studentService.getStudentName2(name);
  }

  @GetMapping("/student/All")
  public List<Student> findAll() {
    return studentService.findAll();
  }
}
