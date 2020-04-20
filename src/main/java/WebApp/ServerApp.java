package WebApp;

import WebApp.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new FirstPageServlet()),"/firstpage/*");
        handler.addServlet(new ServletHolder( new CalcServlet()),"/calc/*");
        handler.addServlet(new ServletHolder(new LoginServlet()),"/login/*");
        handler.addServlet(new ServletHolder(new RegisterServlet()),"/register/*");
        handler.addServlet(new ServletHolder(new RedirectServlet("/register")),"/*");
//        handler.addServlet(new ServletHolder(new RedirectServlet("/login")), "/*");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
