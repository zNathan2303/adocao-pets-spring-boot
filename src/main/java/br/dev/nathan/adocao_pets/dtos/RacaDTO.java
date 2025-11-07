package br.dev.nathan.adocao_pets.dtos;

import br.dev.nathan.adocao_pets.entities.RacaEntity;
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
@Schema(name = "Raça")
public class RacaDTO {
    private Integer id;

    @NotBlank(message = "Nome inválido!")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres!")
    private String nome;

    @NotNull(message = "Id da espécie inválido!")
    private Integer idEspecie;

    public RacaDTO(RacaEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.idEspecie = entity.getEspecie().getId();
    }
}
