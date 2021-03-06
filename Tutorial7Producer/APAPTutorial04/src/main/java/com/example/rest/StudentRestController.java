package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StudentModel;
import com.example.service.StudentService;

@Controller
@RestController
@RequestMapping("/rest")

public class StudentRestController {
   @Autowired
   StudentService studentService;
   
   
   @RequestMapping("/student/view/{npm}")
   public StudentModel view (@PathVariable(value="npm")String npm) {
	   StudentModel student = studentService.selectStudent(npm);
	   return student;
   }
   
   
   @RequestMapping("student/viewall")
   public List<StudentModel> viewAll(Model model) {
    List <StudentModel> students = studentService.selectAllStudents();
	return students ;
}
}
