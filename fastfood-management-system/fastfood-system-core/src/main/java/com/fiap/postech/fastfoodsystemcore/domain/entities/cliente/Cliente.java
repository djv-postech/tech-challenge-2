package com.fiap.postech.fastfoodsystemcore.domain.entities.cliente;

import com.fiap.postech.fastfoodsystemcore.domain.vo.CPF;
import com.fiap.postech.fastfoodsystemcore.domain.vo.Email;

public class  Cliente {

  private String nome;
  private final CPF cpf;
  private Email email;

  public Cliente(String nome, CPF cpf, Email email) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf.getNumero();
  }

  public Email getEmail() {
    return email;
  }

  public void setEmail(Email email){
    this.email = email;
  }
}
