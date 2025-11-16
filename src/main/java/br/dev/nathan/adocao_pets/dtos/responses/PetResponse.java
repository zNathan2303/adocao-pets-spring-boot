package br.dev.nathan.adocao_pets.dtos.responses;

import br.dev.nathan.adocao_pets.entities.PetEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Pet - Response")
public record PetResponse(
    Integer id,
    String nome,
    String fotoUrl,
    Integer idadeAproximada,
    String porte,
    String sexo,
    String descricao,
    RacaResponse raca,
    OngResponse ong
) {
    public PetResponse(PetEntity entity) {
        this(
            entity.getId(),
            entity.getNome(),
            entity.getFotoUrl(),
            entity.getIdadeAproximada(),
            entity.getPorte(),
            entity.getSexo(),
            entity.getDescricao(),
            new RacaResponse(entity.getRaca()),
            new OngResponse(entity.getOng())
        );
    }
}