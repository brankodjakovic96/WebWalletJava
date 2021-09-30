package com.webwallet.applications.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.webwallet.core", "com.webwallet.applications"})
@EntityScan({
        "com.webwallet.core.domain.entities"
})
@EnableJpaRepositories("com.webwallet.core.infrastructure.repositoryInterfaces")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
