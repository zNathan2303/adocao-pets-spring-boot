package br.dev.nathan.adocao_pets.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_pet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 250, nullable = false)
    private String fotoUrl;

    @Column(nullable = false)
    private Integer idadeAproximada;

    @Column(length = 7, nullable = false)
    private String porte;

    @Column(length = 5, nullable = false)
    private String sexo;

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_raca", nullable = false)
    private RacaEntity raca;

    @ManyToOne
    @JoinColumn(name = "id_ong", nullable = false)
    private OngEntity ong;
}
