package com.student.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="student_info")
public class Student {

	@Id
	private long id;
	
	@Column(nullable = false)
	@Size(max = 50, min=10,message = "student name must be 10 to 50 charcters long.")
	private String name;
	
	
	@Column(nullable = false)
	private double age;
	
	@NotNull(message = "City can not be empty")
	@Size(max = 20, min=10,message = "student city must be 10 to 20 charcters long.")
	private String city;

	public  Student() {
	
	}

	public Student(long id, String name,double age,String city) {
	
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getage() {
		return age;
	}

	public void setPrice(double age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCategory(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
	
	
	
	
	
}

