package com.springapp.springApplication.controllers;
import com.springapp.springApplication.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( path = "/api/students")
public class StudentControllers {

    List<Student> studentList = new ArrayList<>(
            List.of(
                    new Student(1, "chanrith", "male"),
                    new Student(2, "LeangSim", "male"),
                    new Student(3, "Phanith", "male")

            )
    );


    @GetMapping
    List<Student> getAllStudents() {
        return studentList;
    }

    @GetMapping(path = "/{id}")
    Student getStudentDetail(@PathVariable Integer id) {
        Student student = new Student();
        studentList.forEach(stu -> {
            if (stu.getId() == id) {
                student.setId(stu.getId());
                student.setName(stu.getName());
                student.setGender(stu.getGender());
            }
        });
        return student;
    }


    @PutMapping(path = "/{id}")
    String updateStudent(@PathVariable Integer id) {
        return  "id = " + id;

    }
}
