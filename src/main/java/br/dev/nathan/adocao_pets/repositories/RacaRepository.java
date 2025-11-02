package br.dev.nathan.adocao_pets.repositories;

import br.dev.nathan.adocao_pets.entities.RacaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RacaRepository extends JpaRepository<RacaEntity, Integer> {
}
