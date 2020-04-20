package WebApp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class FirstPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = new BufferedReader(new FileReader(new File("content/firstpage.html"))).lines().collect(Collectors.joining("\n"));

        try (PrintWriter w = resp.getWriter()) {
            w.write(result);
        }
    }
}
