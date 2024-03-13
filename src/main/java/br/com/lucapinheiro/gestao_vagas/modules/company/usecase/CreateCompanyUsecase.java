package br.com.lucapinheiro.gestao_vagas.modules.company.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.company.Company;
import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.CompanyRepository;
import br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions.UserFoundException;

@Service
public class CreateCompanyUsecase {

    @Autowired
    private CompanyRepository companyRepository;

    public Company execute(Company companyEntity) {
        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);
    }
}