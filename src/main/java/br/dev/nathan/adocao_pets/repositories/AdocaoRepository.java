package br.dev.nathan.adocao_pets.repositories;

import br.dev.nathan.adocao_pets.entities.AdocaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

public interface AdocaoRepository extends JpaRepository<AdocaoEntity, Integer> {

    @NativeQuery(value =
        """
            SELECT EXISTS (
                SELECT 1 FROM tb_pet p JOIN tb_adocao a
                on p.id = a.id_pet
                WHERE p.id = ?1
            )
        """)
    int existeAdocaoComIdDoPet(Integer petId);
}
