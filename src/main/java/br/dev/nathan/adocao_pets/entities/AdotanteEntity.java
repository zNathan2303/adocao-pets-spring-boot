package br.dev.nathan.adocao_pets.entities;

import br.dev.nathan.adocao_pets.dtos.AdotanteDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "tb_adotante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AdotanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;
    private String email;
    private String telefone;

    public AdotanteEntity(AdotanteDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
