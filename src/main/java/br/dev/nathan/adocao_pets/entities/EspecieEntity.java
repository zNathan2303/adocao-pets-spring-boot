package br.dev.nathan.adocao_pets.entities;

import br.dev.nathan.adocao_pets.dtos.EspecieDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "tb_especie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EspecieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    public EspecieEntity(EspecieDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
