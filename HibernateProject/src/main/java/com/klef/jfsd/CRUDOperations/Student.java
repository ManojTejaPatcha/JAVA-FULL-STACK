package com.klef.jfsd.CRUDOperations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student 
{
	@Id  ///primary key=unique+not null
   private int id;
	@Column(name="sname",length=30,nullable = false)
   private String name;
	@Column(name="sgender",length=10,nullable = false)
   private String gender;
	@Column(name="sdofbirth",length=20,nullable = false)
   private String dateofbirth;
	@Column(name="scollege",length=20,nullable = false)
   private String college;
	@Column(name="sdept",length=20,nullable = false)
   private String department;
	@Column(name="syear",nullable = false)
   private int year;
	@Column(length=10,nullable = false)
   private String semester;
	@Column(name="cgpa",nullable=false,precision=4,scale=2)
   private double cgpa;
	@Column(name="sbacklogs",nullable = false)
   private int backlogs;
	@Column(name="scontact",nullable = false,length=20,unique=true)
   private String contact;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getSemester() {
	return semester;
}
public void setSemester(String semester) {
	this.semester = semester;
}
public double getCgpa() {
	return cgpa;
}
public void setCgpa(double cgpa) {
	this.cgpa = cgpa;
}
public int getBacklogs() {
	return backlogs;
}
public void setBacklogs(int backlogs) {
	this.backlogs = backlogs;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
   
   
}
