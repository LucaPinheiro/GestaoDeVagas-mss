package br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe!");
    }
}
