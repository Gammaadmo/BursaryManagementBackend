package org.biic0.org.service;

import org.biic0.org.domain.Student;
import org.biic0.org.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public Student create(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student read(String studentId){
        return (Student) studentRepository.findStudentByStudentId(studentId);
    }
    @Override
    public Student update(Student student){
        return studentRepository.save(student);
    }
    @Override
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public List<Student> findStudentByStudentId(String studentId){
        return studentRepository.findStudentByStudentId(studentId);
    }

}
