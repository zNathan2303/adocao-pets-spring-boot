package br.dev.nathan.adocao_pets.repositories;

import br.dev.nathan.adocao_pets.entities.EnderecoAdotanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoAdotanteRepository extends JpaRepository<EnderecoAdotanteEntity, Integer> {
}
