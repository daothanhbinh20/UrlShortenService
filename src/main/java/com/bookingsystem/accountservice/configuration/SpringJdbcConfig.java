package com.bookingsystem.accountservice.configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

@Configuration
@ComponentScan("com.bookingsystem.accountservice")
public class SpringJdbcConfig {
  @Bean
  public DataSource mysqlDataSource() {
    DriverManager.setLoginTimeout(10);
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://mysql:3306/account_service");
    dataSource.setUsername("username");
    dataSource.setPassword("password");

    return dataSource;
  }
}
