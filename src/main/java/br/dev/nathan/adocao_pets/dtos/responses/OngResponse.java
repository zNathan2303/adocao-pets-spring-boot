package br.dev.nathan.adocao_pets.dtos.responses;

import br.dev.nathan.adocao_pets.entities.OngEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(name = "ONG - Response")
public record OngResponse(
    Integer id,
    String nome,
    String cnpj,
    LocalDate dataFundacao,
    Boolean ativa,
    String telefone,
    String email
) {
    public OngResponse(OngEntity entity) {
        this(
            entity.getId(),
            entity.getNome(),
            entity.getCnpj(),
            entity.getDataFundacao(),
            entity.getAtiva(),
            entity.getTelefone(),
            entity.getEmail()
        );
    }
}
