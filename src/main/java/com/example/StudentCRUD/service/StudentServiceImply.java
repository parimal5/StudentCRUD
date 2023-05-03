package com.example.StudentCRUD.service;

import com.example.StudentCRUD.dao.StudentRepository;
import com.example.StudentCRUD.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImply implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImply(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {

        Optional<Student> result = studentRepository.findById(id);
        Student student = null;
        if(result.isPresent())
            student= result.get();
        else
            throw new RuntimeException("Student Not Found with Id: " + id);
        return student;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
