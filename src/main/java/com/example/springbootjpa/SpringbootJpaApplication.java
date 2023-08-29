package com.example.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

    @Autowired
    EntityManagerFactory emf;
    public static void main(String[] args) {
       SpringApplication app = new SpringApplication(SpringbootJpaApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("emf = " + emf);
    }
}
