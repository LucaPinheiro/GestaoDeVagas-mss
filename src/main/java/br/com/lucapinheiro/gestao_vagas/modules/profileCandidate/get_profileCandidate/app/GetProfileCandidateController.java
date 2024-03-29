package br.com.lucapinheiro.gestao_vagas.modules.profileCandidate.get_profileCandidate.app;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

// Essa classe é um controller get onde vamos retornar as informações do candidato

@RestController
@RequestMapping("/candidate")
public class GetProfileCandidateController {

    @Autowired
    private GetProfileCandidateUsecase getProfileCandidateUsecase;

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')") // Apenas candidatos podem acessar essa rota (ver SecurityConfig.java)
    public ResponseEntity<Object> getProfileCandidate(HttpServletRequest request) {

        var idCandidate = (String) request.getAttribute("candidate_id");

        try {
            var profile = this.getProfileCandidateUsecase.execute(UUID.fromString(idCandidate.toString().toUpperCase()));
            return ResponseEntity.ok().body(profile);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
