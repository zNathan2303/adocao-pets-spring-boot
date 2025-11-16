package br.dev.nathan.adocao_pets.dtos.responses;

import br.dev.nathan.adocao_pets.entities.AdocaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(name = "Adoção - Response")
public record AdocaoResponse(
    Integer id,
    LocalDate dataAdocao,
    AdotanteResponse adotante,
    PetResponse pet
) {
    public AdocaoResponse(AdocaoEntity entity) {
        this(
            entity.getId(),
            entity.getDataAdocao(),
            new AdotanteResponse(entity.getAdotante()),
            new PetResponse(entity.getPet())
        );
    }
}