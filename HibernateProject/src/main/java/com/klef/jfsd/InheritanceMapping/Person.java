package com.klef.jfsd.InheritanceMapping;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity


//Single Table Strategy
/*@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType = DiscriminatorType.STRING,length=20)
@DiscriminatorValue("person")*/

//Table per class Strategy
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//Joined TableStrategy
@Inheritance(strategy = InheritanceType.JOINED)

public class Person {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue

	@Column(name="pid")
	private int id;
	@Column(name="pname",length=100)
    private String name;
	@Column(name="pgender",length=10)
    private String gender;
	@Column(name="pdateofbirth",length=30)
    private String dateofbirth;
	@Column(name="pcollege",length=100)
    private String college;
	@Column(name="pdepartment",length=10)
    private String department;
	@Column(name="pcontact",length=20,unique=true)
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

}
