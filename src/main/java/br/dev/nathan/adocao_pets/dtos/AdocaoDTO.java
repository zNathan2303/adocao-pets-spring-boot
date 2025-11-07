package br.dev.nathan.adocao_pets.dtos;

import br.dev.nathan.adocao_pets.entities.AdocaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Schema(name = "Adoção")
public class AdocaoDTO {

    private Integer id;

    @NotNull(message = "Data de adoção inválida!")
    private LocalDate dataAdocao;

    @NotNull(message = "Id do adotante inválido!")
    private Integer idAdotante;

    @NotNull(message = "Id do pet inválido!")
    private Integer idPet;

    public AdocaoDTO(AdocaoEntity entity) {
        this.id = entity.getId();
        this.dataAdocao = entity.getDataAdocao();
        this.idAdotante = entity.getAdotante().getId();
        this.idPet = entity.getPet().getId();
    }
}
