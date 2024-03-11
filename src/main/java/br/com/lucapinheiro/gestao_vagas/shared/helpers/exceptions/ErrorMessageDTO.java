package br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {

    private String field;
    private String message;

}
