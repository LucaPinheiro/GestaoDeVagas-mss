package br.com.lucapinheiro.gestao_vagas.modules.company.usecase;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.CompanyRepository;
import br.com.lucapinheiro.gestao_vagas.shared.infra.dto.AuthCompanyDTO;

@Service
public class AuthCompanyUsecase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository
        .findByUsername(authCompanyDTO.getUsername())
        .orElseThrow(() -> {
            throw new UsernameNotFoundException("Company not found");
        } );
    
    // Se a company existir, verificar se a senha está correta
    // Se não estiver, lançar exceção
    // Se estiver, retornar o token
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if(!passwordMatches) {
            throw new AuthenticationException();
        }

    }
}
