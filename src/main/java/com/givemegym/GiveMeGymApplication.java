package com.givemegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GiveMeGymApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiveMeGymApplication.class, args);
    }

}
