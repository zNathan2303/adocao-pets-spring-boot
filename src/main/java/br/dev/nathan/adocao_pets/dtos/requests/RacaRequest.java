package br.dev.nathan.adocao_pets.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Raça - Request")
public class RacaRequest {

    @NotBlank(message = "Nome inválido!")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres!")
    private String nome;

    @NotNull(message = "Id da espécie inválido!")
    private Integer idEspecie;

}
