package br.dev.nathan.adocao_pets.dtos;

import br.dev.nathan.adocao_pets.entities.EspecieEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Schema(name = "Espécie")
public class EspecieDTO {

    private Integer id;

    @NotBlank(message = "Nome inválido!")
    @Size(max = 50, message = "O nome pode ter no máximo 50 caracteres!")
    private String nome;

    public EspecieDTO(EspecieEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
