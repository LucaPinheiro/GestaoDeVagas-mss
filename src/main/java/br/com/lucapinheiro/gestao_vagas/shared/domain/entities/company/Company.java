package br.com.lucapinheiro.gestao_vagas.shared.domain.entities.company;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "Company")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo [username] não pode ser vazio")
    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaços em branco ou ser vazio")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres")
    private String password;

    private String website;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
