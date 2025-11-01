package br.dev.nathan.adocao_pets.entities;

import br.dev.nathan.adocao_pets.dtos.OngDTO;
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
    private String nome;
    private String cnpj;
    private LocalDate dataFundacao;
    private Boolean ativa;
    private String telefone;
    private String email;

    public OngEntity(OngDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
