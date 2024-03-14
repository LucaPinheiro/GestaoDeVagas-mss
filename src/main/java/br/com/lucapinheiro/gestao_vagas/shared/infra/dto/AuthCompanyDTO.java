package br.com.lucapinheiro.gestao_vagas.shared.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {
    
    private String username;
    private String password;

}
