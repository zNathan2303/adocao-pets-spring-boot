package br.dev.nathan.adocao_pets.dtos.responses;

import br.dev.nathan.adocao_pets.entities.EnderecoAdotanteEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Endereço do adotante - Response")
public record EnderecoAdotanteResponse(
    Integer id,
    String logradouro,
    String numero,
    String bairro,
    String cidade,
    String estado,
    Integer idAdotante
) {
    public EnderecoAdotanteResponse(EnderecoAdotanteEntity entity) {
        this(
            entity.getId(),
            entity.getLogradouro(),
            entity.getNumero(),
            entity.getBairro(),
            entity.getCidade(),
            entity.getEstado(),
            entity.getAdotante().getId()
        );
    }
}
