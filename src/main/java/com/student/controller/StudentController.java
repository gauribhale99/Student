package com.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student)
	{
		Student savedStudent=this.service.updateStudent(student);
		return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED); //201
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllProductsInfo()
	{
		return new ResponseEntity<List<Student>>(this.service.getAllStudent(),HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}") //uri parameter
	public ResponseEntity<?> getSingleStudent(@PathVariable("id") long id)
	{
		if(this.service.getStudentById(id).isPresent())
		{
			return new ResponseEntity<Student>(this.service.getStudentById(id).get(),HttpStatus.OK);
		}
		else
		{
			Map<String, String> response=new HashMap<>();
			response.put("status", "failed");
			response.put("message", "product id not found");
			return new ResponseEntity<Map<String, String>>(response,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("id")long id)
	{
		if(this.service.getStudentById(id).isPresent())
		{
			this.service.deleteStuById(id);
			Map<String, String> response=new HashMap<>();
			response.put("status", "success");
			response.put("message", "student deleted!!");
			return new ResponseEntity<Map<String, String>>(response,HttpStatus.OK);
		}
		else
		{
			Map<String, String> response=new HashMap<>();
			response.put("status", "failed");
			response.put("message", "student id not found!!");
			return new ResponseEntity<Map<String, String>>(response,HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/product")
	public ResponseEntity<?> updateStudentInfo(@RequestBody Student student)
	{
		if(this.service.getStudentById(student.getId()).isPresent())
		{
			this.service.updateStudent(student);
			Map<String, String> response=new HashMap<>();
			response.put("status", "success");
			response.put("message", "student Info updated!!");
			return new ResponseEntity<Map<String, String>>(response,HttpStatus.OK);
		}
		else
		{
			Map<String, String> response=new HashMap<>();
			response.put("status", "failed");
			response.put("message", "student id not found!!");
			return new ResponseEntity<Map<String, String>>(response,HttpStatus.NOT_FOUND);
		}
	}
	@PatchMapping("/product")
	public ResponseEntity<?> updateProductInfo1(@RequestBody Student student)
	{
		if(this.service.getStudentById(student.getId()).isPresent())
		{
			this.service.updateStudent(student);
			Map<String, String> response=new HashMap<>();
			response.put("status", "success");
			response.put("message", "student Info updated!!");
			return new ResponseEntity<Map<String, String>>(response,HttpStatus.OK);
		}
		else
		{
			Map<String, String> response=new HashMap<>();
			response.put("status", "failed");
			response.put("message", "student id not found!!");
			return new ResponseEntity<Map<String, String>>(response,HttpStatus.NOT_FOUND);
		}
	}
	
	
	}



