package com.example.demo.student;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        var  result = studentRepository.findById(id);
        Student student = result.get();
        return student;  //TODO: clean this up
    }

    public void addStudent(Student student) {

        //Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        //if (studentOptional.isPresent()) {throw new BadRequestException("Email Taken");}
        //You could do other checks as well
        Boolean existsEmail = studentRepository
                .selectExistsEmail(student.getEmail());

        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + student.getEmail() + " taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(
                    "Student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        //Does student with this ID exist?
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"
                ));
        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
                    student.setName(name);
        }
        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)) {

//            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
//            if (studentOptional.isPresent()) {throw new BadRequestException("Email Taken");}
            Boolean existsEmail = studentRepository
                    .selectExistsEmail(email);

            if (existsEmail) {
                throw new BadRequestException(
                        "Email " + email + " taken");
            }

            student.setEmail(email);
        }
        studentRepository.save(student);
    }
}