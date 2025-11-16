package br.dev.nathan.adocao_pets.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Adotante - Request")
public class AdotanteRequest {

    @NotBlank(message = "Nome inválido!")
    @Size(max = 150, message = "O nome pode ter no máximo 150 caracteres!")
    private String nome;

    @NotNull(message = "A idade é obrigatória!")
    @Positive(message = "A idade deve ser um número positivo!")
    private Integer idade;

    @NotBlank(message = "CPF inválido!")
    @Size(max = 11, message = "O CPF pode ter no máximo 11 caracteres!")
    private String cpf;

    @NotBlank(message = "Email inválido!")
    @Email(message = "Formato do email incorreto!")
    @Size(max = 200, message = "O email pode ter no máximo 200 caracteres!")
    private String email;

    @NotBlank(message = "Telefone inválido!")
    @Size(max = 11, message = "O telefone pode ter no máximo 11 caracteres!")
    private String telefone;

}
