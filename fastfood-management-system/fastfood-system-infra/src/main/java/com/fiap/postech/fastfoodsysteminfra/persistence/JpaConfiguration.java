package com.fiap.postech.fastfoodsysteminfra.persistence;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.fiap.postech.fastfoodsysteminfra.persistence")
@EnableMongoRepositories
public class JpaConfiguration {


}
