package com.revature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class AppServlet extends HttpServlet {

 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

     response.setContentType("text/html");
     PrintWriter out = response.getWriter();
     out.println("<html><body>");

     String admin = request.getParameter("name");
     out.println("Welcome to your profile page " +admin);

     request.getRequestDispatcher("navibar.html").include(request, response);

     //request.getRequestDispatcher("InsertData.html").forward(request, response);
     RequestDispatcher rd = request.getRequestDispatcher("/InsertData.html");
     ((RequestDispatcher) rd).include(request, response);
     //get info
     Statement stmnt = null;
     try {
         ResultSet resultSet = stmnt.executeQuery("select * from staff");
         out.println("<table border=1 width=50% height=50%>");
         out.println("<tr><th>Employee Id</th><th>Employee Name</th><th>Employee Title</th><th>Salary</th><tr>");
         while (resultSet.next()){
             String n = resultSet.getString("empid");
             String nm = resultSet.getString("empname");
             int salary = resultSet.getInt("sal");
             out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + salary + "</td></tr>");
         }
         out.println("</table>");
         out.println("</html></body>");
         stmnt.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
out.close();
     //request.getRequestDispatcher("profile.html").include(request, response);

 }

    public void saveEmployee(com.revature.Employee employee) {

        //Employee employee1 = new com.revature.Employee()
        Transaction trans = null;

        // create a configuration object
        Configuration config = new Configuration();

        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = config.buildSessionFactory();
        // ope the session
        Session session = factory.openSession();
            //start trans
            trans = session.beginTransaction();

            //save
            session.persist(employee);
            //commit
            trans.commit();
        }
        public void getEmployee(int id){
        Transaction trans  = null;

        //try n catch block
            // create factory
            //SessionFactory factory = new SessionFactory();
            // open the session
            Session session = null;
            //start transaction
            trans = session.beginTransaction();

            //get employee entity
            com.revature.Employee employee = session.get(com.revature.Employee.class, id);
            System.out.println(employee.getName());
            System.out.println(employee.getTitle());

            //commit
            trans.commit();
        }
        public static void saveOrUpdateEmployee(com.revature.Employee employee){
        Transaction t = null;
            Session session = null;
            //start transaction
            t = session.beginTransaction();
            //save emp
            session.saveOrUpdate(employee);

            //get employee entity
            employee = session.get(com.revature.Employee.class, 11);
            //make changes
            employee.setName("");
            employee.setTitle("");
            employee.setSalary(500);
            //session save/update
            session.saveOrUpdate(employee);
            //commit
            t.commit();
        }
        public void deleteEmployee(int id){
            Session session = null;
            Transaction trnsct = session.beginTransaction();

        //start trans

        }

    }

