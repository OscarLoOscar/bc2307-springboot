package com.example.demo_testcase.model;

import java.beans.Transient;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.example.demo_testcase.Entity.StudentEntity;
import com.example.demo_testcase.Repository.StudentRepository;

@DataJpaTest // inject Repository related Beans
public class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private TestEntityManager entityManager;

  @Test
  void testFindAll() {
    // save (entityManager)
    // findAll
    StudentEntity s1 = new StudentEntity("ABC", 12);

    StudentEntity s2 = new StudentEntity("XYZ", 22);

    StudentEntity s3 = new StudentEntity("IJK", 32);

    // List<StudentEntity> students = List.of(s1, s2, s3);
    // entityManager.persist(students);
    // Mockito.when(studentRepository.findAll()).thenReturn(List.of(s1, s2, s3));

    // the persist method in JPA is typically used to persist a single entity, not a collection of entities.

    // Persist each StudentEntity individually
    entityManager.persist(s1);
    entityManager.persist(s2);
    entityManager.persist(s3);

    // findAll
    List<StudentEntity> studentEntities = studentRepository.findAll();
    assertThat(studentEntities, hasItem(hasProperty("name", equalTo("ABC"))));
    assertThat(studentEntities, hasItem(hasProperty("name", equalTo("XYZ"))));
    assertThat(studentEntities, hasItem(hasProperty("name", equalTo("IJK"))));
    assertThat(studentEntities,
        not(hasItem(hasProperty("name", equalTo("KKK")))));

  }
}
