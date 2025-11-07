package br.dev.nathan.adocao_pets.dtos;

import br.dev.nathan.adocao_pets.entities.EnderecoOngEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Schema(name = "Endereço da ONG")
public class EnderecoOngDTO {

    private Integer id;

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

    @NotBlank(message = "Inscrição Municipal inválida!")
    @Size(max = 20, message = "A Inscrição Municipal pode ter no máximo 20 caracteres!")
    private String inscricaoMunicipal;

    @NotNull(message = "Id da ONG inválido!")
    private Integer idOng;

    public EnderecoOngDTO(EnderecoOngEntity entity) {
        this.id = entity.getId();
        this.logradouro = entity.getLogradouro();
        this.numero = entity.getNumero();
        this.bairro = entity.getBairro();
        this.cidade = entity.getCidade();
        this.estado = entity.getEstado();
        this.inscricaoMunicipal = entity.getInscricaoMunicipal();
        this.idOng = entity.getOng().getId();
    }
}
