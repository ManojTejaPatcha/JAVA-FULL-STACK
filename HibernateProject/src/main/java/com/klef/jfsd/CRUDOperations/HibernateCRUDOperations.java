package com.klef.jfsd.CRUDOperations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateCRUDOperations 
{
  public static void main(String args[])
  {
	  HibernateCRUDOperations crudOperations=new HibernateCRUDOperations();
	  crudOperations.insertStudent();
	 //crudOperations.viewStudent();
     //crudOperations.deleteStudent();
     //crudOperations.updateStudent();


	  
  }
  public void insertStudent()
  {
	  Configuration cfg=new Configuration();
	  cfg.configure("hibernate.cfg.xml");
	  
	  SessionFactory sf=cfg.buildSessionFactory();
	  Session session=sf.openSession();
	  
	  Student  student=new Student();
	  student.setId(105);
	  student.setName("Nabf");
	  student.setGender("SheMale");
	  student.setDateofbirth("23/04/2002");
	  student.setCollege("KLU");
	  student.setDepartment("CSE");
	  student.setYear(3);
	  student.setSemester("ODD");
	  student.setCgpa(9.3);
	  student.setBacklogs(0);
	  student.setContact("9426553252");
	  
	  
	  Transaction t=session.beginTransaction();
	  session.save(student);
	  t.commit(); //Idi rayakapote db change avvadu,confirm rayali
	  
	  System.out.println("Student Object saved Successfully");
	  
	  session.close();
	  sf.close();
	  
  }
  
  public void updateStudent()
  {
	  Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml");
      
      SessionFactory sf = cfg.buildSessionFactory();
      Session session = sf.openSession();
      
      Transaction  t  = session.beginTransaction();
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Student ID:");
      int sid = sc.nextInt();
      
    
      Student s = session.get(Student.class,sid);
      
      if(s!=null)
      {
        System.out.println("Enter Student CGPA:");
          double scgpa = sc.nextDouble();
          System.out.println("Enter Student Backlogs:");
          int sbacklogs = sc.nextInt();
          System.out.println("Enter Student Contact No:");
          String contact = sc.next();
          
          s.setCgpa(scgpa);
          s.setBacklogs(sbacklogs);
          s.setContact(contact);
          
          t.commit();
          System.out.println("Student Object Updated Successfully");
          
      }
      else
      {
        System.out.println("Student Object Not Found");  
      }
      
      sc.close();
      session.close();
      sf.close();  
  }
  public void deleteStudent()
  {
	  Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml");
      
      SessionFactory sf = cfg.buildSessionFactory();
      Session session = sf.openSession();
      
      Transaction t = session.beginTransaction();
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Student ID:");
      int sid = sc.nextInt();
      
      Student student = session.get(Student.class, sid);
      
      if(student!=null)
      {
        session.delete(student);
        t.commit();
        System.out.println("Student Object Deleted Successfully");
      }
      else
      {
        System.out.println("Student Object Not Found");
      }
        
      sc.close();
      session.close();
      sf.close(); 
  }
  
  public void viewStudent()
  {
	  Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml");
      
      SessionFactory sf = cfg.buildSessionFactory();
      Session session = sf.openSession();
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Student ID:");
      int sid = sc.nextInt();
    
      Student student = session.load(Student.class, sid);
      
      System.out.println("****Student Information****");
      System.out.println("Student ID:"+student.getId());
      System.out.println("Student Name:"+student.getName());
      System.out.println("Student DOB:"+student.getDateofbirth());
      System.out.println("Student Department:"+student.getDepartment());
      System.out.println("Student CGPA:"+student.getCgpa());
      System.out.println("Student Contact No:"+student.getContact());
      
      session.close();
      sf.close();
      sc.close();
	  
	  
  }
  
}
