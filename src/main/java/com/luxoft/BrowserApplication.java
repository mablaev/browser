package com.luxoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

//@EnableCaching
@SpringBootApplication
public class BrowserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrowserApplication.class, args);
    }

    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setCacheable(false);
        return resolver;
    }
}
