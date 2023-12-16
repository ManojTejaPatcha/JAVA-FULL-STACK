package com.klef.jfsd.InheritanceMapping;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class InheritanceMappingDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Transaction t = session.beginTransaction();
	       
	       Person p=new Person();
	       p.setName("Krishna");
	       p.setGender("Male");
	       p.setCollege("KLU");
	       p.setDepartment("CSE");
	       p.setDateofbirth("12/12/2000");
	       p.setContact("9090909090");
	       
	       Scholar s=new Scholar();
	       s.setProgram("M.TECH");
	       s.setCgpa(1);
	       s.setHostelstatus("Day Scholar");
	       s.setCareerchoice("Higher Studies");
	       
	       Faculty f=new Faculty();
	       f.setQualification("Ph.D");
	       f.setDesignation("Professor");
	       f.setJoiningdate("01/02/2017");
	       f.setExperience(2.5f);
	       f.setSalary(30000.0);
	       
	       session.save(p);
	       session.save(s);
	       session.save(f);

	       
	       t.commit();
	       System.out.println("Successs..!!");
	       

	       session.close();
	       sf.close();
		
	}
}
