package br.dev.nathan.adocao_pets.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Adoção - Request")
public class AdocaoRequest {

    @NotNull(message = "Data de adoção inválida!")
    private LocalDate dataAdocao = LocalDate.now();

    @NotNull(message = "Id do adotante inválido!")
    private Integer idAdotante;

    @NotNull(message = "Id do pet inválido!")
    private Integer idPet;

}
