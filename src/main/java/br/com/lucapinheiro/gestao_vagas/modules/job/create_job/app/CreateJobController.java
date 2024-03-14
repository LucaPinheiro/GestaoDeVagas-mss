package br.com.lucapinheiro.gestao_vagas.modules.job.create_job.app;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.job.Job;
import br.com.lucapinheiro.gestao_vagas.shared.infra.dto.CreateJobDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class CreateJobController {

    @Autowired
    private CreateJobUsecase createJobUsecase;

    @PostMapping("/")
    public ResponseEntity<Object> createJob(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        try {
            var companyId = request.getAttribute("company_id");

            // Isto é para garantir que o companyId é um UUID válido e não um valor aleatório
            // que pode ser passado na requisição, e não no body da requisição.
            var job = Job.builder()
                    .benefits(createJobDTO.getBenefits())
                    .companyId(UUID.fromString(companyId.toString()))
                    .description(createJobDTO.getDescription())
                    .level(createJobDTO.getLevel())
                    .build();

            var result = this.createJobUsecase.execute(job);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
