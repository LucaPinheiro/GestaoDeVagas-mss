package br.com.lucapinheiro.gestao_vagas.modules.cadidate.create_candidate.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucapinheiro.gestao_vagas.shared.infra.dto.AuthCandidateRequestDTO;

// Esta classe é responsável por receber as requisições de autenticação de candidato
// e retornar o token JWT

@RestController
@RequestMapping("/candidate")
public class AuthCandidateController {

    @Autowired
    private AuthCandidateUsecase authCandidateUsecase;

    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO) {
        try {
            var token = this.authCandidateUsecase.execute(authCandidateRequestDTO);
            return ResponseEntity.ok().body(token); // Retorna o token dentro do body ao passar username e password
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
