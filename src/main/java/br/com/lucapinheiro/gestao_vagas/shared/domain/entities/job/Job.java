package br.com.lucapinheiro.gestao_vagas.shared.domain.entities.job;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.lucapinheiro.gestao_vagas.shared.domain.entities.company.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "Job")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String level;
    private String benefits;

    @ManyToOne()
    @JoinColumn(name="company_id")
    private Company company;

    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
