package com.student.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentImplementation implements StudentService {

	@Autowired
	private StudentRepository repository;
	
	
	@Override
	public Student saveProduct(Student student) {
		
		return this.repository.save(student);
	}
	
	@Override
	public List<Student> getAllStudent() {
		
		return this.repository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(long id) {
		
		return this.repository.findById(id);
	}

	@Override
	public void deleteStuById(long id) {
		
		this.repository.deleteById(id);
	}


	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return this.repository.save(student);
	}
}





