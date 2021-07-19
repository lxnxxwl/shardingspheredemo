package com.lixiunan.twodbcomplex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lixiunan.twodbcomplex.mapper")
public class TwodbComplexApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwodbComplexApplication.class, args);
    }

}
