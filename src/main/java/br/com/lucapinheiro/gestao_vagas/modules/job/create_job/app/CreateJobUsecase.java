package br.com.lucapinheiro.gestao_vagas.modules.job.create_job.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.job.Job;
import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.JobRepository;

@Service 
public class CreateJobUsecase {

    @Autowired
    private JobRepository jobRepository;

    @SuppressWarnings("null")
    public Job execute(Job job) {
        return this.jobRepository.save(job);
    }
}
