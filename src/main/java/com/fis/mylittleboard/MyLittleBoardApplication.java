package com.fis.mylittleboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ComponentScan(basePackages = {"com.fis.mylittleboard.global.jwt"})
@SpringBootApplication
@EnableJpaAuditing
public class MyLittleBoardApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyLittleBoardApplication.class, args);
  }

}
