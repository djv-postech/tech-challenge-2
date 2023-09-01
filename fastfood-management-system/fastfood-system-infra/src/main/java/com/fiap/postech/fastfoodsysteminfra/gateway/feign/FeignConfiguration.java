package com.fiap.postech.fastfoodsysteminfra.gateway.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.fiap.postech.fastfoodsysteminfra"})
public class FeignConfiguration {}
