package org.biic0.org.service;

import org.biic0.org.domain.Student;

import java.util.List;

public interface IStudentService extends IService<Student, String>{
    List<Student> getAll();
}
