package com.gontuseries.studentadmissioncontroller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentInfoRESTAPIController {

	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Student> getStudentsList() {
		Student student1 = new Student();
		student1.setStudentName("john the baptist");

		Student student2 = new Student();
		student2.setStudentName("tommy varden");

		Student student3 = new Student();
		student3.setStudentName("john the turd");

		ArrayList<Student> studentList = new ArrayList<Student>();

		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		return studentList;
	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName) {

		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentHobby("Music");

		return student;
	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateStudent(
			@PathVariable("name") String studentName,
			@RequestBody Student student) {

		System.out.println("studentName " + studentName);
		System.out.println("studentHobby " + student.getStudentHobby()
				+ "  studentname " + student.getStudentName());
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add("key1", "value1");
		return new ResponseEntity<Boolean>(true, httpHeader, HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> postStudent(@RequestBody Student student) {

		System.out.println("studentHobby " + student.getStudentHobby()
				+ "  studentname " + student.getStudentName());
		// insert details of student in to database or else return error

		HttpHeaders header = new HttpHeaders();
		header.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/name").buildAndExpand(student.getStudentName()).toUri()
				.toString());
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteStudent(@RequestBody Student student) {

		System.out.println("studentHobby " + student.getStudentHobby()
				+ "  studentname " + student.getStudentName());

		// delete the specific user from database
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteAllStudent() {

		// delete all student records from database
		System.out.println("deleting all students");
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
