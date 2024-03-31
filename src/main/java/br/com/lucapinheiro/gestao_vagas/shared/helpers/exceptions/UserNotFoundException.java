package br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found!");
    }
}
