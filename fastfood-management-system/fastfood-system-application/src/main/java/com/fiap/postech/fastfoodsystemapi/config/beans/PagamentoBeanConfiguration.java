package com.fiap.postech.fastfoodsystemapi.config.beans;

import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.MercadoPagoGateway;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento.ConfirmacaoDePagamento;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento.CriacaoDePagamento;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagamentoBeanConfiguration {
  private final MercadoPagoGateway mercadoPagoGateway;

  public PagamentoBeanConfiguration(MercadoPagoGateway mercadoPagoGateway) {
    this.mercadoPagoGateway = mercadoPagoGateway;
  }

  @Bean
  public CriacaoDePagamento criacaoDePagamento() {
    return new CriacaoDePagamento(mercadoPagoGateway);
  }

  @Bean
  public ConfirmacaoDePagamento confirmacaoDePagamento() {
    return new ConfirmacaoDePagamento();
  }
}
