package com.example.demo;

import com.example.demo.student.Gender;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJPAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJPAApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
//        return args -> {
//            Student mark = new Student(
//                    "Mark Jones",
//                    "mark.jones@amigoscode.edu",
//                    Gender.MALE
//            );
//            Student maria = new Student(
//                    "Maria Jones",
//                    "maria.jones@amigoscode.edu",
//                    Gender.FEMALE
//            );
//
//            Student ahmed = new Student(
//                    "Ahmed Ali",
//                    "ahmed.ali@amigoscode.edu",
//                    Gender.MALE
//            );
//            Student joe = new Student(
//                    "Joe Davault",
//                    "joe.davault@gmail.com",
//                    Gender.MALE
//            );
//
//            System.out.println("Adding maria and ahmed");
//            studentRepository.save(mark);
//            studentRepository.save(maria);
//            studentRepository.save(ahmed);
//            studentRepository.save(joe);
//
//            System.out.print("Number of students: ");
//            System.out.println(studentRepository.count());
//
//            studentRepository
//                    .findById(2L)
//                    .ifPresentOrElse(
//                            System.out::println,
//                            () -> System.out.println("Student with ID 2 not found"));
//
//            studentRepository
//                    .findById(3L)
//                    .ifPresentOrElse(
//                            System.out::println,
//                            () -> System.out.println("Student with ID 3 not found"));
//
//            System.out.println("Select all students");
//            List<Student> students = studentRepository.findAll();
//            students.forEach(System.out::println);
//
//            System.out.println("Delete maria");
//            studentRepository.deleteById(1L);
//
//            System.out.print("Number of students: ");
//            System.out.println(studentRepository.count());
//        };
//    }


}
