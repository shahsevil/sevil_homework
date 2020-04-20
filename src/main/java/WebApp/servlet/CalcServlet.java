package WebApp.servlet;

import WebApp.entity.Calculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = new BufferedReader(new FileReader(new File("content/calc.html"))).lines().collect(Collectors.joining("\n"));

        try (PrintWriter w = resp.getWriter()) {
            w.write(result);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xs = req.getParameter("x");
        String ys = req.getParameter("y");
        String ops = req.getParameter("op");

        Calculator c = new Calculator();

        String result = c.doOperation(xs, ys, ops);

        try (PrintWriter w = resp.getWriter()) {
            w.write(result);
        }
    }
}
