package br.com.lucapinheiro.gestao_vagas.modules.cadidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.candidate.Candidate;
import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.Candidate_repository_interface;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cadidate")
public class CadidateController {

    @Autowired
    private Candidate_repository_interface candidate_repository_interface;
    
    @PostMapping("/")
    public Candidate createCandidate(@Valid @RequestBody Candidate candidate) {
        return this.candidate_repository_interface.save(candidate);
    }
}
