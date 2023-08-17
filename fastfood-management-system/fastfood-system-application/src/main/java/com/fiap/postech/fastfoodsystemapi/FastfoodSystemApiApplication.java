package com.fiap.postech.fastfoodsystemapi;

import com.fiap.postech.fastfoodsysteminfra.persistence.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan("com.fiap.postech.*")
@Import(JpaConfiguration.class)
public class FastfoodSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastfoodSystemApiApplication.class, args);
	}

}
