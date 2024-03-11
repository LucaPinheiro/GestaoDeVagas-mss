package br.com.lucapinheiro.gestao_vagas.shared.domain.entities;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

// adicionando da dependencia do jakarta.validation para usar as anotações de validação (próprio do Spring)
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data; //lib para gerar os getters e setters

@Data //anotação para gerar os getters e setters de TODOS os atributos da classe
public class Candidate {
    
    private UUID id;
    private String name;

    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não pode conter espaços em branco ou ser vazio")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min=10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres")
    private String password;
    private String description;
    private String curriculum;

}
