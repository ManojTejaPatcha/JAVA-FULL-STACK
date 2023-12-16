package com.klef.jfsd.HQL;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {
  public static void main(String args[]) {
    HQLDemo demo=new HQLDemo();
    // demo.insertcustomer();
    //demo.viewallcustomerscompleteobject();
    //demo.viewallcustomerspartialobject();
    // demo.aggregatefunctions();
     //demo.updatepositionalparams();
     demo.deletepositionalparams();
    // demo.updatenamedparams();
    //demo.deletenamedparams();
    //demo.viewcustomerbyidpositionalparams();
    //demo.viewcustomerbyidnamedparams();
  }
  
  public void insertcustomer() {
    Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
        Customer c = new Customer();
        c.setId(103);
        c.setName("pulkuu");
        c.setGender("MALE");
        c.setAge(51.6f);
        c.setSalary(56000.50);
        c.setContact("9564321345");
        c.setEmail("pulkuu@gmail.com");
        c.setPassword("pulkuuu");
        c.setMaritalstatus(false);
        
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
        
        System.out.println("Customer Object Saved Successfully");
        
        session.close();
        sf.close();
  }
  
  public void viewallcustomerscompleteobject()         //complete object
  {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
        Query qry = session.createQuery("from Customer");
        List<Customer> clist =qry.getResultList();
        System.out.println("***Customers Information***");
        System.out.println("Total Customers= "+clist.size());
        
        for(Customer c:clist) {
          System.out.println(c.toString());
        }
        
        session.close();
        sf.close();
  }
  
  public void viewallcustomerspartialobject()    //partial object
  {
	  Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml");
      
      SessionFactory sf = cfg.buildSessionFactory();
      Session session = sf.openSession();
      
      Query qry = session.createQuery(" select c.id, c.name, c.age, c.salary from Customer c ");
      //c is reference object or alias of type customer
      List<Object[]> clist =  qry.getResultList();
       
       System.out.println("****Customer Information****");
       System.out.println("Total Customers="+clist.size());
       
       for(Object[] obj  :  clist)
       {
         System.out.println("Customer ID:"+obj[0]);
         System.out.println("Customer Name:"+obj[1]);
         System.out.println("Customer Age:"+obj[2]);
         System.out.println("Customer Salary:"+obj[3]);
         System.out.println();
       }
       
       session.close();
       sf.close();
  }
  
  public void aggregatefunctions() {
	  Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml");
      
      SessionFactory sf = cfg.buildSessionFactory();
      Session session = sf.openSession();
      
      Query qry1=session.createQuery("select count(*) from Customer ");
      List list1=qry1.list();
      System.out.println("****count(*)****");
      System.out.println(" Total Customers="+list1.get(0));
      
      Query qry2=session.createQuery("select min(age) from Customer ");
      List list2=qry2.list();
      System.out.println("****min(age)****");
      System.out.println(" Total Customers="+list2.get(0));
      
      Query qry3=session.createQuery("select max(age) from Customer ");
      List list3=qry3.list();
      System.out.println("****min(age)****");
      System.out.println(" Total Customers="+list3.get(0));
      
      Query qry4=session.createQuery("select sum(salary) from Customer ");
      List list4=qry4.list();
      System.out.println("****sum(salary)****");
      System.out.println(" Customers total salary="+list4.get(0));
      
      Query qry5=session.createQuery("select avg(salary) from Customer ");
      List list5=qry5.list();
      System.out.println("****avg(salary)****");
      System.out.println(" Total Customers avg salary="+list5.get(0));
      
      session.close();
      sf.close();
      
      
  }
  
  
  
 public void updatepositionalparams() {
	 Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
     
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     
     Transaction t=session.beginTransaction();
     
     int cid=101;
     float cage=30.5f;
     double csalary=45000.00;
     String contact="8989898123";
     
     Query qry=session.createQuery("update Customer set age=?1,salary=?2,contact=?3 where id=?4");
     qry.setFloat(1, cage);
     qry.setDouble(2, csalary);
     qry.setString(3, contact);
     qry.setInteger(4, cid);
     
    int n= qry.executeUpdate();
    
    if(n>0)
    {
    	System.out.println(n+"Record updated Successfully");
    }
    else {
    	System.out.println("Customer ID not found");
    }
    
    t.commit();
    session.close();
    sf.close();
     
 }
 
 public void deletepositionalparams()
 {
	 Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
     
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     
     Transaction t = session.beginTransaction();
     
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter Customer ID:");
     int cid = sc.nextInt();
     
     Query qry = session.createQuery("  delete from Customer where id=?1 ");
     qry.setInteger(1, cid);
     
     int n = qry.executeUpdate();
     
     if(n>0)
     {
       System.out.println(n+" Record(s) Deleted Successfully");
     }
     else
     {
       System.out.println("Customer ID Not Found");
     }
     
     t.commit();
     session.close();
     sf.close();
     
 }
 
 public void updatenamedparams()
 {
	 Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
     
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     
     Transaction t=session.beginTransaction();
     
     int cid=10;
     float cage=26.7f;
     double csalary=80000.00;
     
     Query qry=session.createQuery("update Customer set age=:v1,salary=:v2 where id=:v3");
     qry.setParameter("v1", cage);
     qry.setParameter("v2", csalary);
     qry.setParameter("v3", cid);

     
    int n= qry.executeUpdate();
    
    if(n>0)
    {
    	System.out.println(n+"Record updated Successfully");
    }
    else {
    	System.out.println("Customer ID not found");
    }
    
    t.commit();
    session.close();
    sf.close();
 }
 
 public void deletenamedparams()
 {
	 Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
     
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     
     Transaction t = session.beginTransaction();
     
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter Customer ID:");
     int cid = sc.nextInt();
     
     Query qry = session.createQuery("  delete from Customer where id=:v ");
     qry.setParameter("v",cid);
     
     
     int n = qry.executeUpdate();
     
     if(n>0)
     {
       System.out.println(n+" Record(s) Deleted Successfully");
     }
     else
     {
       System.out.println("Customer ID Not Found");
     }
     
     t.commit();
     session.close();
     sf.close();
 }
 
 public void viewcustomerbyidpositionalparams()
 {
	 Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
     
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter Customer Id:");
     int cid=sc.nextInt();
     
     
     Query qry=session.createQuery("from Customer where id=?1 ");
     qry.setInteger(1, cid);
     
    // Customer c=(Customer)qry.getSingleResult(); 
     // Gives single object or single result only with this function
     
     List<Customer> clist=qry.list();
     
     if(clist.size()>0)
     {
    	 System.out.println(clist.get(0).toString());  //Because we only have 1 record in db
     //If multiple records use for loop
     }
     else {
    	 System.out.println("Customer id not found");
     }
     
     
    	 
     session.close();
     sf.close();
 
 }
 
 public void viewcustomerbyidnamedparams()
 {Configuration cfg = new Configuration();
 cfg.configure("hibernate.cfg.xml");
 
 SessionFactory sf = cfg.buildSessionFactory();
 Session session = sf.openSession();
 
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter Customer Id:");
 int cid=sc.nextInt();
 
 
 Query qry=session.createQuery("from Customer where id=:v ");
 qry.setParameter("v", cid);
 
// Customer c=(Customer)qry.getSingleResult(); 
 // Gives single object or single result only with this function
 
 List<Customer> clist=qry.list();
 
 if(clist.size()>0)
 {
	 System.out.println(clist.get(0).toString());  //Because we only have 1 record in db
 //If multiple records use for loop
 }
 else {
	 System.out.println("Customer id not found");
 }
 
 
	 
 session.close();
 sf.close();
 }
 
 

}
