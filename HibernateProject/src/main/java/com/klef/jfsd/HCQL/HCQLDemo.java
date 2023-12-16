package com.klef.jfsd.HCQL;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HCQLDemo {
  public static void main(String args[]) {
    HCQLDemo demo = new HCQLDemo();
   // demo.insertproduct();
  //demo.restrictionsdemo();
//    demo.ProjectionswithAggregateFunction();
//    demo.ProjectswithProperties();
//    demo.multiplierestrictions();
//    demo.ordereddemo();
//    demo.HCQLAll();
    demo.pagination();
  }
  
  public void insertproduct() {
    Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
        Product product = new Product();
        product.setId(1002);
        product.setCategory("Books");
        product.setName("Jerry");
        product.setVendor("Amazon");
        product.setCost(2000.0);
        product.setStock(10);
        product.setReview("Nice Product");
        
        Transaction t = session.beginTransaction();
        session.save(product);
        t.commit();
        
        System.out.println("Product Object Saved Successfully");
        
        session.close();
        sf.close();
  }
  
  public void restrictionsdemo() {
    Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
        Criteria c1 = session.createCriteria(Product.class);
        List<Product> plist1 =  c1.list();
        System.out.println("****All Products****");
        System.out.println("Total Products= "+plist1.size());
        
        if(plist1.size()>0) {
          for(Product p:plist1) {
            System.out.println(p.toString());
          }
        }
        else {
          System.out.println("Product Data Not Found");
        }
        
        Criteria c2 = session.createCriteria(Product.class);
        c2.add(Restrictions.eq("category", "furniture"));
        //category = "furniture" where category is a property
        List<Product> plist2 =  c2.list();
        System.out.println("****eq(Equal) restriction****");
        System.out.println("Total Products= "+plist2.size());
        
        if(plist2.size()>0) {
          for(Product p:plist2) {
            System.out.println(p.toString());
          }
        }
        else {
          System.out.println("Product Data Not Found");
        }
        
        Criteria c3 = session.createCriteria(Product.class);
        c3.add(Restrictions.lt("cost", 10000.0));
        //cost<10000.0, where cost is a property
        List<Product> plist3 =  c3.list();
        System.out.println("****lt(Less than) restriction****");
        System.out.println("Total Products= "+plist3.size());
        
        if(plist3.size()>0) {
          for(Product p:plist3) {
            System.out.println(p.toString());
          }
        }
        else {
          System.out.println("Product Data Not Found");
        }
        
        Criteria c4 = session.createCriteria(Product.class);
        c4.add(Restrictions.gt("cost", 10000.0));
      //cost>10000.0, where cost is a property
        List<Product> plist4 =  c4.list();
        System.out.println("****gt(Greater than) restriction****");
        System.out.println("Total Products= "+plist4.size());
        
        if(plist4.size()>0) {
          for(Product p:plist4) {
            System.out.println(p.toString());
          }
        }
        else {
          System.out.println("Product Data Not Found");
        }
        
        Criteria c5 = session.createCriteria(Product.class);
        c5.add(Restrictions.le("stock", 15));
        //stock<=15, where stock is a property
        List<Product> plist5 =  c5.list();
        System.out.println("****le(Less than or equals) restriction****");
        System.out.println("Total Products= "+plist5.size());
        if(plist5.size()>0) {
            for(Product p:plist5) {
              System.out.println(p.toString());
            }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c6 = session.createCriteria(Product.class);
          c6.add(Restrictions.ge("stock", 30));
          //stock>=30, where stock is a property
          List<Product> plist6 =  c6.list();
          System.out.println("****ge(Greater than or equals) restriction****");
          System.out.println("Total Products= "+plist6.size());
          
          if(plist6.size()>0) {
            for(Product p:plist6) {
              System.out.println(p.toString());
            }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c7 = session.createCriteria(Product.class);
          c7.add(Restrictions.between("cost", 20000.0, 40000.0));
          //cost>=20000.0 & cost<=40000.0, where cost is a property
          List<Product> plist7 =  c7.list();
          System.out.println("****between restriction****");
          System.out.println("Total Products= "+plist7.size());
          
          if(plist7.size()>0) {
            for(Product p:plist7) {
              System.out.println(p.toString());
            }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c8 = session.createCriteria(Product.class);
//          c8.add(Restrictions.in("stock",new Integer[]{10,20,30}));
          //stock = 10 or stock =20 or stock =30
//          c8.add(Restrictions.in("category",new String[]{"furniture", "gadgets"}));
          //category="furniture" or category = "gadgets"
          
          c8.add(Restrictions.in("stock",10,20,30));
          //stock = 10 or stock =20 or stock =30
          List<Product> plist8 =  c8.list();
          System.out.println("****in restriction****");
          System.out.println("Total Products= "+plist8.size());
          
          if(plist8.size()>0) {
            for(Product p:plist8) {
              System.out.println(p.toString());
            }
          }
          else {
            System.out.println("Product Data Not Found");
          } 
          
          Criteria c9 = session.createCriteria(Product.class);
          c9.add(Restrictions.idEq(1005));
          //id equals to 1005
          List<Product> plist9 =  c9.list();
          System.out.println("****idEq restriction****");
          System.out.println("Total Products= "+plist9.size());
          
          if(plist9.size()>0) {
            for(Product p:plist9) {
              System.out.println(p.toString());
            }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c10 = session.createCriteria(Product.class);
          c10.add(Restrictions.like("name", "s%"));
          //product name starts with s
          List<Product> plist10 =  c10.list();
          System.out.println("****like restriction****");
          System.out.println("Total Products= "+plist10.size());
          
          if(plist10.size()>0) {
            for(Product p:plist10) {
              System.out.println(p.toString());
            }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c11 = session.createCriteria(Product.class);
//          c11.add(Restrictions.isNotNull("review"));         //review is a property
          c11.add(Restrictions.isNull("review"));             //review is a property
          List<Product> plist11 =  c11.list();
          System.out.println("****isNotNull restriction****");
          System.out.println("Total Products= "+plist11.size());
          
          if(plist11.size()>0) {
            for(Product p:plist11) {
              System.out.println(p.toString());
            }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          session.close();
          sf.close();
          
    }
    
    public void ProjectionswithAggregateFunction() {
      Configuration cfg = new Configuration();
          cfg.configure("hibernate.cfg.xml");
          
          SessionFactory sf = cfg.buildSessionFactory();
          Session session = sf.openSession();
          
          System.out.println("*****Projections with Aggregate Functions*****");
          
          Criteria c1 = session.createCriteria(Product.class);
          c1.setProjection(Projections.rowCount());  //count(*)
          
          List list1 = c1.list();
          System.out.println("*****count(*)*****");
          System.out.println("Total Products= "+list1.get(0));
          
          Criteria c2 = session.createCriteria(Product.class);
          c2.setProjection(Projections.count("category"));  
          //count("category"), where category is a property
          
          List list2 = c2.list();
          System.out.println("*****count(category)*****");
          System.out.println("Total Products= "+list2.get(0));
          
          Criteria c3 = session.createCriteria(Product.class);
          c3.setProjection(Projections.sum("cost"));  
          //sum("cost"), where cost is a property
          
          List list3 = c3.list();
          System.out.println("*****sum(cost)*****");
          System.out.println("Total Product's cost= "+list3.get(0));
          
          Criteria c4 = session.createCriteria(Product.class);
          c4.setProjection(Projections.avg("cost"));  
          //avg("cost"), where cost is a property
          
          List list4 = c4.list();
          System.out.println("*****avg(cost)*****");
          System.out.println("Average Product's cost= "+list4.get(0));
          
          Criteria c5 = session.createCriteria(Product.class);
          c5.setProjection(Projections.min("stock"));  
          //min("stock"), where cost is a property
          
          List list5 = c5.list();
          System.out.println("*****min(stock)*****");
          System.out.println("Minimum Product's stock= "+list5.get(0));
          
          Criteria c6 = session.createCriteria(Product.class);
          c6.setProjection(Projections.max("stock"));  
          //max("stock"), where cost is a property
          
          List list6 = c6.list();
          System.out.println("*****max(stock)*****");
          System.out.println("Maximum Product's stock= "+list6.get(0));
          
          Criteria c7 = session.createCriteria(Product.class);
          c7.setProjection(Projections.countDistinct("category"));
          //category is a property
          List list7 = c7.list();
          System.out.println("*****distinct count(category)*****");
          System.out.println("Distinct count of Category= "+list7.get(0));
          
          
          session.close();
          sf.close();
      }
    
    public void ProjectswithProperties() {
      Configuration cfg = new Configuration();
          cfg.configure("hibernate.cfg.xml");
          
          SessionFactory sf = cfg.buildSessionFactory();
          Session session = sf.openSession();
          
          System.out.println("*****Projections with Properties*****");
          
          Criteria c1 = session.createCriteria(Product.class);
          c1.setProjection(Projections.id());
          
          List list1 =c1.list();
          System.out.println("*****Id Property*****");    //This is @Id property not id variable property
          if(list1.size()>0) {
          for(int i=0;i<list1.size();i++) {
            System.out.println(list1.get(i));
          }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c2 = session.createCriteria(Product.class);
          c2.setProjection(Projections.property("name"));
          //name property
          List list2 =c2.list();
          System.out.println("*****Name Property*****");
          if(list2.size()>0) {
          for(int i=0;i<list2.size();i++) {
            System.out.println(list2.get(i));
          }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c3 = session.createCriteria(Product.class);
          c3.addOrder(Order.desc("cost"));
          //descending order based on cost property
          c3.setProjection(Projections.property("cost"));
          //cost property
          List list3 =c3.list();
          System.out.println("*****Cost Property*****");
          if(list3.size()>0) {
          for(int i=0;i<list3.size();i++) {
            System.out.println(list3.get(i));
          }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c4 = session.createCriteria(Product.class);
          c4.setProjection(Projections.projectionList().add( Projections.property("id")).add(Projections.property("name")).add(Projections.property("cost")));
          List<Object[]> plist = c4.list();
          System.out.println("*****Multiple Projections*****");
          
          if(plist.size()>0) {
            for(Object[] obj:plist) {
              System.out.println("Product ID= "+obj[0]);
              System.out.println("Product Name= "+obj[1]);
              System.out.println("Product Cost= "+obj[2]);
              System.out.println();
              
            }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c5 = session.createCriteria(Product.class);
          c5.setProjection(Projections.distinct(Projections.property("category")));
          //where category is property
          List list5 =c5.list();
          System.out.println("*****Distinct Category Property*****");
          if(list5.size()>0) {
          for(int i=0;i<list5.size();i++) {
            System.out.println(list5.get(i));
          }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          
          session.close();
          sf.close();
    }
    
    public void multiplierestrictions() {
      Configuration cfg = new Configuration();
          cfg.configure("hibernate.cfg.xml");
          
          SessionFactory sf = cfg.buildSessionFactory();
          Session session = sf.openSession();
          
          Criteria c1 = session.createCriteria(Product.class);
          c1.add(Restrictions.and(Restrictions.eq("stock", 15),Restrictions.lt("stock", 30)));
          //stock =15 and stock is less than 30 where stock is a property name
          
          List<Product> plist1 =  c1.list();
          System.out.println("****and restriction****");
          System.out.println("Total Products="+plist1.size());
          if(plist1.size()>0)
          {
             for(Product p : plist1)
             {
               System.out.println(p.toString());
             }
          }
          else
          {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c2 = session.createCriteria(Product.class);
          c2.add(Restrictions.or(Restrictions.gt("stock", 15),Restrictions.lt("cost", 25000.0)));
          //stock >15 or cost < 25000 where stock and cost are property names
          
          List<Product> plist2 =  c2.list();
          System.out.println("****or restriction****");
          System.out.println("Total Products="+plist2.size());
          if(plist2.size()>0)
          {
             for(Product p : plist2)
             {
               System.out.println(p.toString());
             }
          }
          else
          {
            System.out.println("Product Data Not Found");
          }
          
          Criteria c3 = session.createCriteria(Product.class);
          c3.add(Restrictions.not(Restrictions.lt("cost", 15000.0)));
          //cost>=15000.0
          List<Product> plist3 =  c3.list();
          System.out.println("****or restriction****");
          System.out.println("Total Products="+plist3.size());
          if(plist3.size()>0)
          {
             for(Product p : plist3)
             {
               System.out.println(p.toString());
             }
          }
          else
          {
            System.out.println("Product Data Not Found");
          }
          
          session.close();
          sf.close();
    }
    
    public void ordereddemo() {
      Configuration cfg = new Configuration();
          cfg.configure("hibernate.cfg.xml");
          
          SessionFactory sf = cfg.buildSessionFactory();
          Session session = sf.openSession();
          
          Criteria c1 = session.createCriteria(Product.class);
        //c1.addOrder(Order.asc("category"));  //ascending order on category
          c1.addOrder(Order.desc("name"));    //descending order on name
          List<Product> plist1 =  c1.list();
          System.out.println("****All Products****");
          System.out.println("Total Products= "+plist1.size());
          
          if(plist1.size()>0) {
            for(Product p:plist1) {
              System.out.println(p.toString());
            }
          }
          else {
            System.out.println("Product Data Not Found");
          }
          
          session.close();
          sf.close();
    }
    
    public void HCQLAll() {
      Configuration cfg = new Configuration();
          cfg.configure("hibernate.cfg.xml");
          
          SessionFactory sf = cfg.buildSessionFactory();
          Session session = sf.openSession();
          
          Criteria c = session.createCriteria(Product.class);
          c.add(Restrictions.lt("cost", 30000.0));  //cost<30000.0, where cost is property
          c.setProjection(Projections.property("name"));  //name is property
          c.addOrder(Order.desc("cost"));  //descending order based on cost property
          List list = c.list();
          System.out.println("****HCQL with Restriction + Projection + Order****");
             if(list.size()>0)
             {
               for(int i=0;i<list.size();i++)
                 {
                  System.out.println(list.get(i)); 
                 }
             }
             else
             {
               System.out.println("Product Data Not Found");
             }
             
             
             session.close();
             sf.close();
    }
          
    public void pagination()
    {
    	 Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg.xml");
         
         SessionFactory sf = cfg.buildSessionFactory();
         Session session = sf.openSession();
         
         Criteria c1 = session.createCriteria(Product.class);
         c1.setFirstResult(1);
         c1.setMaxResults(2); //number of records to be displayed
         List<Product> plist1 =  c1.list();
         System.out.println(" Products count= "+plist1.size());
         
         if(plist1.size()>0) {
           for(Product p:plist1) {
             System.out.println(p.toString());
           }
         }
         else {
           System.out.println("Product Data Not Found");
         }
         
    }
    
  }