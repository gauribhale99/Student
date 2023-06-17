package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.entity.Student;

public interface StudentService {
	public Student saveProduct(Student student);
	public List<Student> getAllStudent();
	public Optional<Student> getStudentById(long id);
	public void deleteStuById(long id);
	public Student updateStudent(Student student);

}


