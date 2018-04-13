package com.example.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.StudentModel;
@Service
public class StudentDaoImpl implements StudentDAO {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public StudentModel selectStudent(String npm) {
		StudentModel student = restTemplate.getForObject("http://localhost:8080/rest/student/view/" +npm, StudentModel.class);
		return student;
	}

	@Override
	public List<StudentModel> selectAllStudent() {
		List<StudentModel> students = (List<StudentModel>) restTemplate.getForObject("http://localhost:8080/rest/student/viewall",StudentModel.class);
		return students;
	}
	
	@Bean 
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
