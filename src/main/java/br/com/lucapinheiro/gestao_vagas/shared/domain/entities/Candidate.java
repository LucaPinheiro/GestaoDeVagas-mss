package br.com.lucapinheiro.gestao_vagas.shared.domain.entities;

import java.util.UUID;

import lombok.Data; //lib para gerar os getters e setters

@Data //anotação para gerar os getters e setters de TODOS os atributos da classe
public class Candidate {
    
    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String curriculum;

}
