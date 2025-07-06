package hello.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    // 빈등록
    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
