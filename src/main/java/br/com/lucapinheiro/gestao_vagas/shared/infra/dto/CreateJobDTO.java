package br.com.lucapinheiro.gestao_vagas.shared.infra.dto;

import lombok.Data;

// De acordo com o projeto geral, esse DTO serve para criar um novo Job. Ele é usado no controller de Job.

@Data
public class CreateJobDTO {
    
    private String description;
    private String benefits;
    private String level;

}
