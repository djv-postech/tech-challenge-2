package com.fiap.postech.fastfoodsystemapi.api.auth;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String authJWT;

    public JwtResponse(String token) {
        this.authJWT = token;
    }

    public String getToken() {
        return this.authJWT;
    }

}