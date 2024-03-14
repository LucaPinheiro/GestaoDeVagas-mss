package br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.company.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Optional<Company> findByUsernameOrEmail(String username, String email);
    Optional<Company> findByUsername(String username);
}