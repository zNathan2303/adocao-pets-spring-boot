package br.dev.nathan.adocao_pets.repositories;

import br.dev.nathan.adocao_pets.entities.AdotanteEntity;
import br.dev.nathan.adocao_pets.entities.EnderecoAdotanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface AdotanteRepository extends JpaRepository<AdotanteEntity, Integer> {

    @NativeQuery(value =
        """
            SELECT * FROM tb_endereco_adotante
            WHERE id_adotante = ?1;
        """)
    List<EnderecoAdotanteEntity> listarEnderecosDeUmAdotante(Integer id);
}
