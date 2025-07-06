package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

@HandlesTypes(value = {AppInit.class, HelloInit.class})
public class MyContainerInitV2 implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("MyContainerInitV2.onStartup");
        System.out.println("set = " + set);
        System.out.println("MyContainerInitV2 servletContext = " + servletContext);

        for (Class<?> appInitClass : set) {
            try {
                final Object instance = appInitClass.getDeclaredConstructor().newInstance();

                if (instance instanceof AppInit appInit) {
                    appInit.onStartup(servletContext);
                } else if (instance instanceof HelloInit helloInit) {
                    helloInit.go(servletContext);
                } else {
                    System.out.println("Unknown type: " + instance.getClass().getName());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
