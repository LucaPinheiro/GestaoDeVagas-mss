package br.com.lucapinheiro.gestao_vagas.shared.infra.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Esse DTO é responsável por retornar o token de autenticação para o usuário se autenticar
// Ele é utilizado na camada de aplicação do módulo de candidato para retornar o token de autenticação
// Se não for possível autenticar o usuário, é lançada uma exceção de autenticação

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCandidateResponseDTO {

    private String acess_token;
    private Long expires_in; // Data de expiração do token

}
