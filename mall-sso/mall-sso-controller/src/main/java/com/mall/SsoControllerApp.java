package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/*
scanBasePackages 扫面其他包路径，后期需要调整包
 */
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},scanBasePackages = { "com.mall.*"})
@SpringBootApplication
public class SsoControllerApp {
    public static void main(String[] args) {
        SpringApplication.run(SsoControllerApp.class, args);
    }
}
