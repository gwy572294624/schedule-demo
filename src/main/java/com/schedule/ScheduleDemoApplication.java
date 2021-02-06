package com.schedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.schedule.mapper")
public class ScheduleDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleDemoApplication.class, args);
    }

}
