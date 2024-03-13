package br.com.lucapinheiro.gestao_vagas.modules.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucapinheiro.gestao_vagas.modules.job.usecase.CreateJobUsecase;
import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.job.Job;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUsecase createJobUsecase;

    @PostMapping("/")
    public ResponseEntity<Object> createJob(@Valid @RequestBody Job job) {
        try {
            var result = this.createJobUsecase.execute(job);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
