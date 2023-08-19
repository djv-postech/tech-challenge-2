package com.fiap.postech.fastfoodsystemapi.api.cliente.records;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroCliente(String nome, @NotNull @CPF(message = "CPF inválido") String cpf, @Email(message = "E-mail inválido") String email) {

    public Cliente convertToCliente() {
        return new Cliente(nome, new com.fiap.postech.fastfoodsystemcore.domain.vo.CPF(cpf),
                new com.fiap.postech.fastfoodsystemcore.domain.vo.Email(email));
    }
}
