package com.codeing.tabuser;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.codeing.tabuser.mapper")
@SpringBootApplication
public class TabUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(TabUserApplication.class, args);
    }

}
