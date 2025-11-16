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
@Schema(name = "Pet - Request")
public class PetRequest {

    @NotBlank(message = "Nome inválido!")
    @Size(max = 50, message = "O nome pode ter no máximo 50 caracteres!")
    private String nome;

    @NotBlank(message = "URL da foto inválida!")
    @Size(max = 250, message = "A URL da foto pode ter no máximo 250 caracteres!")
    private String fotoUrl;

    @NotNull(message = "Idade aproximada inválida!")
    private Integer idadeAproximada;

    @NotBlank(message = "Porte inválido!")
    @Size(max = 7, message = "O porte pode ter no máximo 7 caracteres!")
    private String porte;

    @NotBlank(message = "Sexo do pet inválido!")
    @Size(max = 5, message = "O sexo do pet pode ter no máximo 5 caracteres!")
    private String sexo;

    @NotBlank(message = "Descrição inválida!")
    private String descricao;

    @NotNull(message = "Id da raça inválido!")
    private Integer idRaca;

    @NotNull(message = "Id da ong inválido!")
    private Integer idOng;

}
