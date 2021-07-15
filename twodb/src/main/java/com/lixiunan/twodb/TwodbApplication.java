package com.lixiunan.twodb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lixiunan.twodb.mapper")
public class TwodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwodbApplication.class, args);
    }

}
