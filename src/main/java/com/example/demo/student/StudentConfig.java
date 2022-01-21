package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

        @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student joe = new Student("Joe Davault", "joe@davault.dev", LocalDate.of(1968, Month.DECEMBER, 3),
                    Gender.MALE);
            Student janelle = new Student("Janelle Davault", "janelle@davault.dev",
                    LocalDate.of(1994, Month.MAY, 24), Gender.MALE);
            Student ashley = new Student("Ashley Davault", "adavault@davault.dev",
                    LocalDate.of(1992, Month.AUGUST, 28), Gender.FEMALE);

            studentRepository.saveAll(
                    List.of(joe, ashley, janelle)
            );
        };
    };
}

