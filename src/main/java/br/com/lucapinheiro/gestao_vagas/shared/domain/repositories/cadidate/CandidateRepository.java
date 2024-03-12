package br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.candidate.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
    Optional <Candidate> findByUsernameOrEmail(String username, String email);

}
