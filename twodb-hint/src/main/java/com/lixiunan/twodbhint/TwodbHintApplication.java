package com.lixiunan.twodbhint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lixiunan.twodbhint.mapper")
public class TwodbHintApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwodbHintApplication.class, args);
    }

}
