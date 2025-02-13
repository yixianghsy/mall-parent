package com.mall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SearchControllerApp {

    public static void main(String[] args) {
        SpringApplication.run(SearchControllerApp.class, args);
    }
}
