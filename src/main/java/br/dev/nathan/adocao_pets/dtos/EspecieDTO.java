package br.dev.nathan.adocao_pets.dtos;

import br.dev.nathan.adocao_pets.entities.EspecieEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EspecieDTO {

    private Integer id;
    private String nome;

    public EspecieDTO(EspecieEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
