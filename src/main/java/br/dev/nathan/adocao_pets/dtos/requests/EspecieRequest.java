package br.dev.nathan.adocao_pets.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Espécie - Request")
public class EspecieRequest {

    @NotBlank(message = "Nome inválido!")
    @Size(max = 50, message = "O nome pode ter no máximo 50 caracteres!")
    private String nome;

}
