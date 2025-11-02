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
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String inscricaoMunicipal;

    @ManyToOne
    @JoinColumn(name = "id_ong")
    private OngEntity ong;
}
