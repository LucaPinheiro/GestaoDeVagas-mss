package br.com.lucapinheiro.gestao_vagas.modules.apply_job.app;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.CandidateRepository;
import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.JobRepository;
import br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions.JobNotFoundException;
import br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions.UserNotFoundException;

@Service
public class ApplyJobCandidateUsecase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    // ID do Candidato
    // ID da Vaga
    public void execute(UUID idCandidate, UUID idJob) {

        // Validar se o candidato existe
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        // Validar se a vaga existe
        this.jobRepository.findById(idJob).orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        // Candidato se inscreve na vaga
    }
}
