package com.fiap.postech.fastfoodsystemapi;

import com.fiap.postech.fastfoodsystemapi.config.ControllerExceptionHandler;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.FeignConfiguration;
import com.fiap.postech.fastfoodsysteminfra.persistence.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan("com.fiap.postech.*")
@Import({JpaConfiguration.class, FeignConfiguration.class, ControllerExceptionHandler.class})
public class FastFoodSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastFoodSystemApiApplication.class, args);
	}

}
