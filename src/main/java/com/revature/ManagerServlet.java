
package com.revature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/para.jsp")
public class ManagerServlet extends HttpServlet {
    private EmployeeDao employeeDao;


    //this.employeeDao = new EmployeeDao();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navibar.html").include(request, response);
        out.println("Please click on the activity you want to do next:");
        request.getRequestDispatcher("user-list.jsp").include(request, response);
        String action = request.getServletPath();

        switch (action){
            case "/new":
                newForm(request, response);

                break;
            case "insert":
                try {
                    insertEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case  "/delete":
                try {
                    deleteEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case  "edit":
                try {
                    editForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                try {
                    updateEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;

        }
    }
    private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("para.jsp");
        dispatcher.forward(request, response);
    }
    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        int salary = Integer.parseInt(request.getParameter("salary"));
        Employee newEmployee = new Employee(id,name,title,salary);
        employeeDao.addEmployee(newEmployee);
        response.sendRedirect("list");

        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id =Integer.parseInt(request.getParameter("id"));
        employeeDao.deleteEmployee(id);
        response.sendRedirect("list");
    }
    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeDao.getEmployeeById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("para.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }
    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id =Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        int salary = Integer.parseInt(request.getParameter("salary"));
        Employee employee = new Employee(id,name,title,salary);
        employeeDao.updateEmployee(employee);
        response.sendRedirect("list");
        RequestDispatcher dispatcher = request.getRequestDispatcher("para.jsp");
        dispatcher.forward(request, response);
    }
    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Employee>listEmployee =employeeDao.getEmployees();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}

   /* ResultSet resultSet = response.executeQuery("select * from staff");
            out.println("<table border=1 width=50% height=50%>");
                    out.println("<tr><th>Employee Id</th><th>Employee Name</th><th>Employee Title</th><th>Salary</th><tr>");
                    while (resultSet.next()) {
                    String n = resultSet.getString("emp_id");
                    String nm = resultSet.getString("name");
                    int salary = resultSet.getInt("salary");
                    out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + salary + "</td></tr>");
                    }
                    out.println("</table>");
                    out.println("</html></body>");*/