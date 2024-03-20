package com.fis.mylittleboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyLittleBoardApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyLittleBoardApplication.class, args);
  }

}
