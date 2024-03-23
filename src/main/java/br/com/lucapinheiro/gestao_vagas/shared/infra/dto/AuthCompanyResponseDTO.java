package br.com.lucapinheiro.gestao_vagas.shared.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCompanyResponseDTO {

    private String acess_token;
    private Long expire_in;
    
}
