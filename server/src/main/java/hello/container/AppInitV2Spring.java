package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements AppInit{
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartup");

        // 스프링 컨테이너 생성
        final AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(HelloConfig.class);

        // 스프링 mvc 디스패처 서블릿 생성, 스프링 컨테이너 연결
        final DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);

        // 디스패처 서블릿을 서블릿 컨테이너에 등록(이름 주의! dispatcherV2)
        final ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV2", dispatcherServlet);

        // /spring/* 경로로 요청이 오면 디스패처 서블릿이 처리하도록 매핑
        servlet.addMapping("/spring/*");
    }
}
