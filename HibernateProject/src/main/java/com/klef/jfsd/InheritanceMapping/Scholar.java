package com.klef.jfsd.InheritanceMapping;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("scholar")

public class Scholar extends Person {
    @Column(name="sprogram",length=20)
	private String program;
    @Column(name="scgpa",precision=4,scale=2)
    private double cgpa;
    @Column(name="sbacklogs")
	private int backlogs;
    @Column(name="shostelstatus",length=30)
	private String hostelstatus;
    @Column(name="scareerchoice",length=50)
	private String careerchoice;
    
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
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
	public String getHostelstatus() {
		return hostelstatus;
	}
	public void setHostelstatus(String hostelstatus) {
		this.hostelstatus = hostelstatus;
	}
	public String getCareerchoice() {
		return careerchoice;
	}
	public void setCareerchoice(String careerchoice) {
		this.careerchoice = careerchoice;
	}
	
}
