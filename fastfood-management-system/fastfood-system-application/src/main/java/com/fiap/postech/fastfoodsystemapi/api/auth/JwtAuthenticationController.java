package com.fiap.postech.fastfoodsystemapi.api.auth;


import com.fiap.postech.fastfoodsysteminfra.security.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//FIXME - Organizar pacotes, anotaçoes..
@RestController
@CrossOrigin
@Tag(name = "Autenticação", description = "Rest api para operações de gerenciamento de json web tokens.")
public class JwtAuthenticationController {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Operation(summary = "Validar token")
    @GetMapping("/validar/{token}")
    public boolean validarToken(@PathVariable String token) {
        return jwtTokenUtil.validateToken(token);
    }

    @Operation(summary = "Gerar novo token")
    @GetMapping(value = "/gerar-token/{cpf}")
    public ResponseEntity<?> gerarToken(@PathVariable String cpf) throws Exception {

        //TODO - Criar validaçao de cliente, buscar cpf na base, tratamento para caso cliente exista, caso nao exista, etc

        String authToken = jwtTokenUtil.generateToken(cpf);

        return ResponseEntity.ok(new JwtResponse(authToken));
    }
}