package com.example.demo_testcase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_testcase.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
