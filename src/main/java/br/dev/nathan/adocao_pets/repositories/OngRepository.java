package br.dev.nathan.adocao_pets.repositories;

import br.dev.nathan.adocao_pets.entities.OngEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository extends JpaRepository<OngEntity, Integer> {
}
