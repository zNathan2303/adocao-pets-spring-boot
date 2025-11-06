package br.dev.nathan.adocao_pets.repositories;

import br.dev.nathan.adocao_pets.entities.EnderecoOngEntity;
import br.dev.nathan.adocao_pets.entities.OngEntity;
import br.dev.nathan.adocao_pets.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface OngRepository extends JpaRepository<OngEntity, Integer> {

    @NativeQuery(value =
        """
            SELECT * FROM tb_ong
            WHERE ativa = 1;
        """)
    List<OngEntity> listarOngsAtivas();

    @NativeQuery(value =
        """
            SELECT * FROM tb_pet
            WHERE id_ong = ?1;
        """)
    List<PetEntity> listarPetsDeUmaOng(Integer ongId);

    @NativeQuery(value =
        """
            SELECT * FROM tb_endereco_ong
            WHERE id_ong = ?1;
        """)
    List<EnderecoOngEntity> listarEnderecosDeUmaOng(Integer id);
}
