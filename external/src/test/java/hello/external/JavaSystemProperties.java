package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class JavaSystemProperties {
    public static void main(String[] args) {
        final Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("Key: {}, Value: {}", key, properties.get(String.valueOf(key)));
        }

        final String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        log.info("url: {}, username: {}, password: {}", url, username, password);
    }
}
