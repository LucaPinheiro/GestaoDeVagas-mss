package br.com.lucapinheiro.gestao_vagas.modules.company.create_company.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.company.Company;
import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.CompanyRepository;
import br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions.UserFoundException;

@Service
public class CreateCompanyUsecase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Company execute(Company company) {
        this.companyRepository
                .findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

                var password = passwordEncoder.encode(company.getPassword());
                company.setPassword(password);

        return this.companyRepository.save(company);
    }
}