package com.bwsk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启事务
@MapperScan("com.bwsk.mapper") // 扫描的mapper
public class SmartconstructionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartconstructionApplication.class, args);
    }

}
