package hello.container;

import jakarta.servlet.ServletContext;

public interface HelloInit {

    void go(ServletContext servletContext);

}
