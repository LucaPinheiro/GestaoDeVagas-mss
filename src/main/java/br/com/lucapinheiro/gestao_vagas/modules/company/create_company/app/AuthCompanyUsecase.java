package br.com.lucapinheiro.gestao_vagas.modules.company.create_company.app;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.CompanyRepository;
import br.com.lucapinheiro.gestao_vagas.shared.infra.dto.AuthCompanyDTO;
import br.com.lucapinheiro.gestao_vagas.shared.infra.dto.AuthCompanyResponseDTO;

@Service
public class AuthCompanyUsecase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository
                .findByUsername(authCompanyDTO.getUsername())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Username/password incorrect");
                });

        // Se a company existir, verificar se a senha está correta
        // Se não estiver, lançar exceção
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        // Se estiver, retornar o token
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var expiresIn = Instant.now().plus(Duration.ofHours(2));

        var token = JWT.create()
                .withIssuer("javagas")
                .withExpiresAt(expiresIn)
                .withSubject(company.getId().toString())
                .withClaim("roles", Arrays.asList("COMPANY"))
                .sign(algorithm);

            var authCompanyResponseDTO = AuthCompanyResponseDTO.builder()
            .acess_token(token)
            .expire_in(expiresIn.toEpochMilli())
            .build();
        return authCompanyResponseDTO;
    }
}
