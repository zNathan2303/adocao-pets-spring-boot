package br.dev.nathan.adocao_pets.dtos.responses;

import br.dev.nathan.adocao_pets.entities.EspecieEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Espécie - Response")
public record EspecieResponse(
    Integer id,
    String nome
) {
    public EspecieResponse(EspecieEntity entity) {
        this(
            entity.getId(),
            entity.getNome()
        );
    }
}
