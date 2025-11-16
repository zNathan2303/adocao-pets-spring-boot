package br.dev.nathan.adocao_pets.dtos.responses;

import br.dev.nathan.adocao_pets.entities.AdotanteEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Adotante - Response")
public record AdotanteResponse(
    Integer id,
    String nome,
    Integer idade,
    String cpf,
    String email,
    String telefone
) {
    public AdotanteResponse(AdotanteEntity entity) {
        this(
            entity.getId(),
            entity.getNome(),
            entity.getIdade(),
            entity.getCpf(),
            entity.getEmail(),
            entity.getTelefone()
        );
    }
}
