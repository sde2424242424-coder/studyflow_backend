package com.imir.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        System.out.println("VERSION 0.5 TEST");
        SpringApplication.run(BackendApplication.class, args);
    }
}