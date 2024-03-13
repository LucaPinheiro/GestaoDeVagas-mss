package br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.job.Job;

public interface JobRepository extends JpaRepository<Job, UUID>{
    
}
