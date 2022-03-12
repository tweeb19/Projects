import com.revature.EmployeeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private EmployeeDao employeeDao;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navibar.html").include(request, response);


        String username = request.getParameter("username");
        String password = request.getParameter("password");

// when user enter correct details
        if (username.equals("admin") && password.equals("king")) {
            out.println("<br>You have successfully logged in");
            out.println("<br>Welcome back " + username);

            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);

        } else if (username.equals("chaos1") && password.equals("trouble")) {
            //RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeProfileServlet");
            //requestDispatcher.forward(request, response);
            out.println("<br>You have successfully logged in");
            out.println("<br>Welcome back " + username);
        } else {
            out.println("Sorry, please try again");
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            ((RequestDispatcher) rd).include(request, response);
        }


        //add buttons for views
        out.println("<hr>");

       /* out.println("<button class='bttn-group' onclick='getData()'>View Pending Approvals</button>");
        out.println("<button class='bttn-group' onclick='getData()'>View Receipts</button>");
        out.println("<button class='bttn-group' onclick='getData()'>View Reimbursements for All Employees</button>");
        out.println("<button class='bttn-group' onclick='getData()'>Add/View/Edit Employee Credentials</button>");
        out.println("<button class='bttn-group' onclick='getData()'>Add/Update/Delete Claim</button>");
        out.println("<button class='bttn-group' onclick='getData()'>Request Additional Info</button>");*/





        out.println("<html><body><b>Successfully Inserted" + "</b></body></html>");

        //add maruee
        out.println("<marquee>DEADLINE FOR ALL REPORTS DUE MARCH 25, 2022......>");
        out.println("<hr>");


        // append the username in the query string
        out.println("<h1><a href='ManagerServlet?a=" + username + "'>Click Here to access employees</a></h1>");
        out.close();
    }
}

