package br.dev.nathan.adocao_pets.dtos.responses;

import br.dev.nathan.adocao_pets.entities.RacaEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Raça - Response")
public record RacaResponse(
    Integer id,
    String nome,
    EspecieResponse especie
) {
    public RacaResponse(RacaEntity entity) {
        this(
            entity.getId(),
            entity.getNome(),
            new EspecieResponse(entity.getEspecie())
        );
    }
}