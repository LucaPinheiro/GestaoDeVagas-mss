package br.com.lucapinheiro.gestao_vagas.modules.cadidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.Candidate;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cadidate")
public class CadidateController {
    
    @PostMapping("/")
    public void createCandidate(@Valid @RequestBody Candidate candidate) {
        System.out.println("Creating candidate: " + candidate.getName());
        System.out.println(candidate.getEmail());
    }
}
