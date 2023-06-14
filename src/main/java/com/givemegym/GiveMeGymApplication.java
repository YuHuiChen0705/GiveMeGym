package com.givemegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan  //掃描 servlet組件
@SpringBootApplication
public class GiveMeGymApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiveMeGymApplication.class, args);
    }

}
