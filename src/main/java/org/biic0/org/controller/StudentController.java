package org.biic0.org.controller;

import org.biic0.org.domain.Student;
import org.biic0.org.repository.StudentRepository;
import org.biic0.org.repository.UserRepository;
import org.biic0.org.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;


    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository, UserRepository userRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }
    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        try {
            if (student == null) {
                return ResponseEntity.badRequest().body("Student cannot be null.");
            }

            // Validate student data if needed, for example checking for null values in important fields.
            studentService.create(student);
            return ResponseEntity.status(HttpStatus.CREATED).body("Student created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating student: " + e.getMessage());
        }
    }
    @GetMapping("/read/{studentId}")
    public ResponseEntity<Student> readStudent(@PathVariable String studentId) {
        try {
            Student readStudent = studentService.read(studentId);
            return new ResponseEntity<>(readStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        try {
            if (student.getStudentId() == null || student.getStudentId().isEmpty()) {
                return ResponseEntity.badRequest().body("Student ID cannot be null or empty.");
            }

            studentService.update(student);
            return ResponseEntity.status(HttpStatus.OK).body("Student updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student: " + e.getMessage());
        }
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = studentService.getAll();
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/find/{studentId}")
    public ResponseEntity<List<Student>> findStudentsByStudentId(@PathVariable String studentId) {
        try {
            List<Student> students = studentService.findStudentByStudentId(studentId);
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
