package br.com.lucapinheiro.gestao_vagas.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucapinheiro.gestao_vagas.modules.company.usecase.CreateCompanyUsecase;
import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.company.Company;
import br.com.lucapinheiro.gestao_vagas.shared.helpers.exceptions.UserFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired // injeta a dependencia do usecase para o controller poder usar o metodo execute do usecase
    private CreateCompanyUsecase createCompanyUsecase; // cria uma variavel do tipo usecase

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Company company) { 
        try {
            var result = this.createCompanyUsecase.execute(company); // não pode dar o return direto
            return ResponseEntity.ok().body(result); // guarda na variavel, depois retorna o resultado dentro do body
        } catch (UserFoundException e) { // se der erro de usuario encontrado
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
