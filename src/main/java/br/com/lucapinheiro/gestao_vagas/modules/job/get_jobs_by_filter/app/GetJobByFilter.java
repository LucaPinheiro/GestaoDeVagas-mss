package br.com.lucapinheiro.gestao_vagas.modules.job.get_jobs_by_filter.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.job.Job;
import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.JobRepository;

@Service
public class GetJobByFilter {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> execute(String filter) {
        return this.jobRepository.findByDescriptionContaining(filter);
    }
}
