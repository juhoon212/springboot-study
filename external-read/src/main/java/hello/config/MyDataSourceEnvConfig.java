package hello.config;

import hello.datasource.MyDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
public class MyDataSourceEnvConfig {

    private final Environment env;

    public MyDataSourceEnvConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public MyDataSource myDataSource() {
        final String url = env.getProperty("my.datasource.url");
        final String username = env.getProperty("my.datasource.username");
        final String password = env.getProperty("my.datasource.password");
        final int maxConnection = env.getProperty("my.datasource.etc.max-connection", Integer.class);
        final Duration timeout = env.getProperty("my.datasource.etc.timeout", Duration.class);
        final List<String> options = env.getProperty("my.datasource.etc.options", List.class);

        return new MyDataSource(url, username, password, maxConnection, timeout, options);
    }
}
