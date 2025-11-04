package br.dev.nathan.adocao_pets.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_endereco_ong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EnderecoOngEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String logradouro;

    @Column(length = 20, nullable = false)
    private String numero;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 2, nullable = false)
    private String estado;

    @Column(length = 20, nullable = false)
    private String inscricaoMunicipal;

    @ManyToOne
    @JoinColumn(name = "id_ong", nullable = false)
    private OngEntity ong;
}
