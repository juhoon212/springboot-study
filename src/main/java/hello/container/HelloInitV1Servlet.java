package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class HelloInitV1Servlet implements HelloInit {

    @Override
    public void go(ServletContext servletContext) {
        final ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet2", new HelloServlet());
        helloServlet.addMapping("/hello");
    }
}
