package br.dev.nathan.adocao_pets.entities;

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

    @Column(length = 100, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_especie", nullable = false)
    private EspecieEntity especie;
}
