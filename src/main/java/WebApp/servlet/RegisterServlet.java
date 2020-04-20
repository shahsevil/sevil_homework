package WebApp.servlet;

import WebApp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = new BufferedReader(new FileReader(new File("content/register.html"))).lines().collect(Collectors.joining("\n"));

        try (PrintWriter w = resp.getWriter()) {
            w.write(result);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName= req.getParameter("name");
        String password= req.getParameter("password");
        String password_r= req.getParameter("password");

        User user= new User();

        String result= user.doRegister(userName,password,password_r);

        try (PrintWriter w = resp.getWriter()) {
            w.write(result);
        }
    }

}
