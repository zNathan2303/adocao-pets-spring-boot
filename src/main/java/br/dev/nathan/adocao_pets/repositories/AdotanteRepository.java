package br.dev.nathan.adocao_pets.repositories;

import br.dev.nathan.adocao_pets.entities.AdotanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdotanteRepository extends JpaRepository<AdotanteEntity, Integer> {
}
