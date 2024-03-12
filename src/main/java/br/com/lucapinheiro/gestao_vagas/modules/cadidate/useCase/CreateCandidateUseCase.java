package br.com.lucapinheiro.gestao_vagas.modules.cadidate.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.candidate.Candidate;
import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.Candidate_repository_interface;
import br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions.UserFoundException;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private Candidate_repository_interface candidate_repository_interface;

    public Candidate execute(Candidate candidate) {
        this.candidate_repository_interface
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException(); //Se achar o user retorna o erro falando que já existe
                });
        return this.candidate_repository_interface.save(candidate); 
    }
}
