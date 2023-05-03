package com.example.StudentCRUD.controller;

import com.example.StudentCRUD.entity.Student;
import com.example.StudentCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Student> students = studentService.findAll();

        model.addAttribute("students", students);

        return "list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Student student = new Student();

        model.addAttribute("student", student);

        return "showFormForAdd";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
        Student student =  studentService.findById(id);

        model.addAttribute("student", student);

        return "showFormForAdd";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("mobile") Student student){

        studentService.save(student);

        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int id){
        studentService.deleteById(id);
        return "redirect:/list";
    }
}
