package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@EntityScan({"main"})
@SpringBootApplication(
        exclude = {UserDetailsServiceAutoConfiguration.class}
)
public class SpringMock {
    public SpringMock() {
    }

    public static void main(String[] args) {
        SpringApplication.run(org.example.SpringMock.class, args);
    }
}
