package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {


    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Autowired
    private StudentRepository underTest;
    @Test
    void itShouldCheckIfStudentExistsByEmail() {
        //Given
        String email = "joe.davault@gmail.com";
        Student student = new Student( "Joe Davault", email,
                LocalDate.of(1968, Month.DECEMBER, 3),
                Gender.FEMALE);
        underTest.save(student);
        //When
        Boolean expected = underTest.selectExistsEmail(email);
        //Then, asset
        assertThat(expected).isTrue();
    }
    @Test
    void itShouldCheckThatStudentEmailDoesNotExist() {
        //Given
        String email = "joe.davault@gmail.com";
        //When
        Boolean expected = underTest.selectExistsEmail(email);
        //Then, asset
        assertThat(expected).isFalse();
    }
}