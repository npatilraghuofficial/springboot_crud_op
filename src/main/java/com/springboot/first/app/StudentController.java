package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Raghavendra","patil");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> Students = new ArrayList<>();
		
		Students.add(new Student("roshan","p"));

		Students.add(new Student("apurva","kul"));
		Students.add(new Student("aish","jo"));
		Students.add(new Student("priy","shyam"));
		return Students;
		
	}
	
//	http://localhost:8080/student/raghav/patil
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(	@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
	return new Student(firstName,lastName);
	}
	
	@GetMapping("/student/query")

	public Student StudentQueryParam(@RequestParam(name="firstName")String firstName,@RequestParam(name="lastName")String lastName) {
		
		
		return new Student(firstName,lastName);
		
		
	}
}
