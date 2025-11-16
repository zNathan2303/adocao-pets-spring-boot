package br.dev.nathan.adocao_pets.entities;

import br.dev.nathan.adocao_pets.dtos.requests.OngRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Entity
@Table(name = "tb_ong")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OngEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 14, nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private LocalDate dataFundacao;

    @Column(nullable = false)
    private Boolean ativa = true;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Column(length = 200, nullable = false)
    private String email;

    public OngEntity(OngRequest dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
