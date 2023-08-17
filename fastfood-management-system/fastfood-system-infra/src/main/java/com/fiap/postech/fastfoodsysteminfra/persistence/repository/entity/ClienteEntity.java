package com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "clientes")
public class ClienteEntity {

  @Id
  private String cpf;
  private String nome;
  private String email;

  public ClienteEntity(String nome, String cpf, String email) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
  }

  public static ClienteEntity from(Cliente cliente) {
    return new ClienteEntity(cliente.getNome(), cliente.getCpf(), cliente.getEmail());
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ClienteEntity(Cliente cliente) {
    this.nome = cliente.getNome();
    this.cpf = cliente.getCpf();
    this.email = cliente.getEmail();
  }

  public ClienteEntity() {}
}
