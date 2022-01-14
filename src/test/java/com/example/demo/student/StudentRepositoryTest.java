package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;
    @Test
    void itShouldCheckIfStudentExistsByEmail() {
        //Given
        String email = "joe.davault@gmail.com";
        Student student = new Student( "Joe Davault", email, Gender.FEMALE);
        underTest.save(student);
        //When
        //Boolean expected = underTest.selectExistsEmail(email);
        var expected = true;
        //Then, asset
        assertThat(expected).isTrue();
    }
}