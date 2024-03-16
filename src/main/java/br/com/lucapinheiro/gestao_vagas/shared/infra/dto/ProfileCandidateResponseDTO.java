package br.com.lucapinheiro.gestao_vagas.shared.infra.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Essa classe é um DTO onde vamos retornar as informações do candidato atraves do id

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileCandidateResponseDTO {

    private String description;
    private String username;
    private String email;
    private UUID id;
    private String name;
}
