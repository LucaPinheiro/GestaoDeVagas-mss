package br.com.lucapinheiro.gestao_vagas.shared.domain.entities.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// adicionando da dependencia do jakarta.validation para usar as anotações de validação (próprio do Spring)
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data; //lib para gerar os getters e setters

@Data //anotação para gerar os getters e setters de TODOS os atributos da classe
@Entity(name = "candidate") //anotação para criar a tabela no banco de dados
public class Candidate {
    
    @Id //PK
    @GeneratedValue(strategy = GenerationType.UUID) //auto increment UUID
    private UUID id;
    private String name;

    @NotBlank(message = "O campo [username] não pode ser vazio")
    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaços em branco ou ser vazio")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min=10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres")
    private String password;
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
