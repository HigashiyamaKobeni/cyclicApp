package com.ft1.cycleApp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// MapperScan annotation specify position of Mapper interface in current project, will load all all interface when project run
@MapperScan("com.ft1.cycleApp.mapper")
public class CircleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircleApplication.class, args);
    }

}
