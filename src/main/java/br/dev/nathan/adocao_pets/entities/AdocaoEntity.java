package br.dev.nathan.adocao_pets.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_adocao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AdocaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate dataAdocao;

    @ManyToOne
    @JoinColumn(name = "id_adotante", nullable = false)
    private AdotanteEntity adotante;

    @OneToOne
    @JoinColumn(name = "id_pet", nullable = false)
    private PetEntity pet;
}
