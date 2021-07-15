package com.lixiunan.onedb;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lixiunan.onedb.mapper")
public class OnedbApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnedbApplication.class, args);
    }

}
