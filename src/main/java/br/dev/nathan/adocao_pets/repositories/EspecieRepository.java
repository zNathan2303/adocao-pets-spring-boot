package br.dev.nathan.adocao_pets.repositories;

import br.dev.nathan.adocao_pets.entities.EspecieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<EspecieEntity, Integer> {
}
