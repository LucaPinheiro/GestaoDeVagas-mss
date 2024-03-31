package br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException() {
        super("Job not found!");
    }
}
