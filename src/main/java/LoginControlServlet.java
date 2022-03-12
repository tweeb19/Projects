import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = "/imageUpload",
        initParams =
                {
                        @WebInitParam(name = "saveDir", value = "D:/FileUpload"),
                        @WebInitParam(name = "allowedTypes", value = "jpg,jpeg,gif,png")
                }
)
public class LoginControlServlet {
    public class ImageUploadServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            String saveDir = getInitParameter("saveDir");
            String fileTypes = getInitParameter("allowedTypes");

            PrintWriter writer = response.getWriter();

            writer.println("saveDir = " + saveDir);
            writer.println("fileTypes = " + fileTypes);
        }
    }
}