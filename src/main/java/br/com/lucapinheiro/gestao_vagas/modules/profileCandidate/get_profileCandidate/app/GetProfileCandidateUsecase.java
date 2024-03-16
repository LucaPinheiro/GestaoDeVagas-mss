package br.com.lucapinheiro.gestao_vagas.modules.profileCandidate.get_profileCandidate.app;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lucapinheiro.gestao_vagas.shared.domain.repositories.cadidate.CandidateRepository;
import br.com.lucapinheiro.gestao_vagas.shared.infra.dto.ProfileCandidateResponseDTO;

// Essa classe é um usecase onde vamos retornar as informações do candidato atraves do id
// ai depois a gente já chama no controller

@Service
public class GetProfileCandidateUsecase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        @SuppressWarnings("null")
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User not found");
                });
        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();
        return candidateDTO;
    }
}
