package br.dev.nathan.adocao_pets.entities;


import br.dev.nathan.adocao_pets.dtos.RacaDTO;
import br.dev.nathan.adocao_pets.repositories.RacaRepository;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_raca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RacaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_especie")
    private EspecieEntity especie;
}
