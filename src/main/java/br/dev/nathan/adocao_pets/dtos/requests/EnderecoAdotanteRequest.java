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
@Schema(name = "Endereço do adotante - Request")
public class EnderecoAdotanteRequest {

    @NotBlank(message = "Logradouro inválido!")
    @Size(max = 200, message = "O logradouro pode ter no máximo 200 caracteres!")
    private String logradouro;

    @NotBlank(message = "Número inválido!")
    @Size(max = 20, message = "O número pode ter no máximo 20 caracteres!")
    private String numero;

    @NotBlank(message = "Bairro inválido!")
    @Size(max = 100, message = "O bairro pode ter no máximo 100 caracteres!")
    private String bairro;

    @NotBlank(message = "Cidade inválida!")
    @Size(max = 100, message = "A cidade pode ter no máximo 100 caracteres!")
    private String cidade;

    @NotBlank(message = "Estado inválido!")
    @Size(max = 2, min = 2, message = "O estado deve ter 2 caracteres!")
    private String estado;

    @NotNull(message = "Id do adotante inválido!")
    private Integer idAdotante;

}
