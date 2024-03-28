package br.com.lucapinheiro.gestao_vagas.modules.job.get_jobs_by_filter.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucapinheiro.gestao_vagas.modules.cadidate.create_candidate.app.CreateCandidateUseCase;
import br.com.lucapinheiro.gestao_vagas.modules.profileCandidate.get_profileCandidate.app.GetProfileCandidateUsecase;
import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.job.Job;

@RestController
public class GetJobByFilterController {

    @Autowired
    private GetProfileCandidateUsecase getProfileCandidateUsecase;

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @Autowired
    private GetJobByFilter getJobByFilterUsecase;

    @GetMapping("/job")
    @PreAuthorize("hasRole('CANDIDATE')")
    public List<Job> findJobByFilter(@RequestParam String filter) {
        return this.getJobByFilterUsecase.execute(filter);
    }
}
