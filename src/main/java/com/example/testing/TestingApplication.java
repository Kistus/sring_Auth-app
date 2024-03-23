package com.example.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingApplication {
    private JwtCore jwtCore;
    @Autowired
    public TestingApplication(JwtCore jwtCore) {
        this.jwtCore = jwtCore;
    }
    public static void main(String[] args) {
        SpringApplication.run(TestingApplication.class, args);
    }

}
