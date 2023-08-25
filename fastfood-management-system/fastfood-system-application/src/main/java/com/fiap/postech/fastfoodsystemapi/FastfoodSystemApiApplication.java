package com.fiap.postech.fastfoodsystemapi;

import com.fiap.postech.fastfoodsystemapi.config.ControllerExceptionHandler;
import com.fiap.postech.fastfoodsysteminfra.persistence.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan("com.fiap.postech.*")
//FIXME: criar classe de config
@EnableFeignClients(basePackages = {"com.fiap.postech.fastfoodsysteminfra"})
@Import({JpaConfiguration.class, ControllerExceptionHandler.class})
public class FastfoodSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastfoodSystemApiApplication.class, args);
	}

}
