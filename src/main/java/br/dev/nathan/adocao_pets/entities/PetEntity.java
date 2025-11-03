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
    private String nome;
    private String fotoUrl;
    private Integer idadeAproximada;
    private String porte;
    private String sexo;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_raca")
    private RacaEntity raca;

    @ManyToOne
    @JoinColumn(name = "id_ong")
    private OngEntity ong;
}
