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

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(length = 200, nullable = false)
    private String email;

    @Column(length = 11)
    private String telefone;

    public AdotanteEntity(AdotanteDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
