import com.revature.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

public class EmployeeProfileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navibar.html").include(request, response);

        String admin = request.getParameter("name");
        out.println("Welcome to your profile page " + admin);
        out.println("\nPlease click on the activity you want to do next:");

        out.println("<html><body>");
        //create a form that have invisible text field
        out.println("<form action='' method='get'>");
        out.println("<input type='hidden' name='name' value='" + admin + "' />");
        out.println("<input type='submit' value='Send' />");
        out.println("</form>");

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:mydsn", "root", "rooty");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from staff");


        out.println("<table border=1 width=50% height=50%>");
        out.println("<tr><th>Employee Id</th><th>Employee Name</th><th>Employee Title</th><th>Salary</th><tr>");
        while (rs.next())
        {
            int emp_id = Integer.parseInt(request.getParameter("emp_id"));
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        int salary = Integer.parseInt(request.getParameter("salary"));

        out.println("<tr><td>" + emp_id + "</td><td>" +name + "</td><td>" + title + "</td><td>" + salary + "</td></tr>");}
        out.println("</table>");
        out.println("</html></body>");} catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
//test db






        //show actual links to activities
         out.println("<button class='bttn-group' onclick='getData()'>View/Update Contact Info</button>");
        out.println("<button class='bttn-group' onclick='getData()'>Add/Update/Delete Claim</button>");
        out.println("<button class='bttn-group' onclick='getData()'>View Reimbursements</button>");

        //side menu
        request.getRequestDispatcher("profile.html").include(request, response);
        //upload a receipt for expense
        out.println("<form action='' method='get'>");
        out.println("<label for='anyfile'>Select a file:</label>");
        out.println("<input type='file' id='anyfile' name='anyfile'><br><br>");
        out.println("<input type='file' id='fileElmnt' multiple accept='image/*' style='display:none'>");
        out.println("<button id='fileSelect'>Select Files</button>");

        out.println("<html><body>");
        out.close();

    }
}
