package br.com.lucapinheiro.gestao_vagas.modules.cadidate.create_candidate.app;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.CandidateRepository;
import br.com.lucapinheiro.gestao_vagas.shared.infra.dto.AuthCandidateRequestDTO;
import br.com.lucapinheiro.gestao_vagas.shared.infra.dto.AuthCandidateResponseDTO;

public class AuthCandidateUsecase {

    @Value("${security.token.secret.candidate}")
    private String secret;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Esse método serve para vereificar se o usuário existe no banco de dados
    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidateRequestDTO) throws AuthenticationException {
        var candidate = this.candidateRepository.findByUsername(authCandidateRequestDTO.username())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Username/password incorrect");
                });

        var passwordMatches = this.passwordEncoder.matches(authCandidateRequestDTO.password(), candidate.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256("secret"); // Algoritiimo de criptografia

        // Esse token é gerado para o usuário se autenticar
        var token = JWT.create()
                .withIssuer("javagas")
                .withSubject(candidate.getId().toString())
                .withClaim("roles", Arrays.asList("candidate"))
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .sign(algorithm);

        var authCandidateResponse = AuthCandidateResponseDTO.builder()
        .acess_token(token)
        .build();

        return authCandidateResponse;
    }
}
