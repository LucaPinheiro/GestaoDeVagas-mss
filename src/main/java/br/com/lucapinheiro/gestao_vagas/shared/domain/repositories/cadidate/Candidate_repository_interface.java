package br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.candidate.Candidate;

public interface Candidate_repository_interface extends JpaRepository<Candidate, UUID> {

}
