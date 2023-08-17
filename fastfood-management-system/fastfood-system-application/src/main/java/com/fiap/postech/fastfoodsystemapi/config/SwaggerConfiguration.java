package com.fiap.postech.fastfoodsystemapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public OpenAPI customOpenAPI() {
    //FIXME Definir nome do sistema, colocar mais opçoes nos Swagger
    return new OpenAPI().info(new Info().title("Tech Challenge").version("1.0"));
  }

}
