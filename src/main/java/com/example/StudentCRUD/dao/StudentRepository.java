package com.example.StudentCRUD.dao;

import com.example.StudentCRUD.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // This interface  will provide all basic CRUD operation needed. No need to write any code manually as we're using repo  JpaRepository<Student, Integer>.
    //  JpaRepository<Student, Integer> --> Student is entity name. Integer is the datatype of our Primary key in Database.

}
