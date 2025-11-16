package br.dev.nathan.adocao_pets.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ONG - Request")
public class OngRequest {

    @NotBlank(message = "Nome inválido!")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres!")
    private String nome;

    @NotBlank(message = "CNPJ inválido!")
    @Size(max = 14, message = "O CNPJ pode ter no máximo 14 caracteres!")
    private String cnpj;

    @NotNull(message = "Data de fundação inválida!")
    private LocalDate dataFundacao;

    private Boolean ativa = true;

    @NotBlank(message = "Telefone inválido!")
    @Size(max = 20, message = "O telefone pode ter no máximo 20 caracteres!")
    private String telefone;

    @NotBlank(message = "Email inválido!")
    @Email(message = "Formato do email incorreto!")
    @Size(max = 200, message = "O email pode ter no máximo 200 caracteres!")
    private String email;

}
