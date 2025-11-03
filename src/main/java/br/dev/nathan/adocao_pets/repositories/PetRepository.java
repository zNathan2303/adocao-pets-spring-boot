package br.dev.nathan.adocao_pets.repositories;

import br.dev.nathan.adocao_pets.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity, Integer> {
}
