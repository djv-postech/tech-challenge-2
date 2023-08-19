package com.fiap.postech.fastfoodsysteminfra.persistence.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{

    public ProdutoNaoEncontradoException(String message){
        super(message);
    }
}
