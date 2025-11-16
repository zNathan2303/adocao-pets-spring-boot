package br.dev.nathan.adocao_pets.dtos.responses;

import br.dev.nathan.adocao_pets.entities.EnderecoOngEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Endereço da ONG - Response")
public record EnderecoOngResponse (
    Integer id,
    String logradouro,
    String numero,
    String bairro,
    String cidade,
    String estado,
    String inscricaoMunicipal,
    OngResponse ong
) {
    public EnderecoOngResponse(EnderecoOngEntity entity) {
        this(
            entity.getId(),
            entity.getLogradouro(),
            entity.getNumero(),
            entity.getBairro(),
            entity.getCidade(),
            entity.getEstado(),
            entity.getInscricaoMunicipal(),
            new OngResponse(entity.getOng())
        );
    }
}
