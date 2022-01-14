package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;
    @Test
    void itShouldCheckIfStudentExistsByEmail() {
        //Given
        String email = "joe.davault@gmail.com";
        Student student = new Student("Joe", "Davault", email, Gender.FEMALE);
        underTest.save(student);
        //When
        Boolean expected = underTest.selectExistsEmail(email);

        //Then, asset
        assertThat(expected).isTrue();
    }
}