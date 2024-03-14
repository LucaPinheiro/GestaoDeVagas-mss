package br.com.lucapinheiro.gestao_vagas.modules.cadidate.create_candidate.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.candidate.Candidate;
import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.CandidateRepository;
import br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions.UserFoundException;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate execute(Candidate candidate) {
        this.candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException(); // Se achar o user retorna o erro falando que já existe
                });
        return this.candidateRepository.save(candidate);
    }
}
