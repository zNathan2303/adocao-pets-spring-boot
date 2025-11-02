package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.AdotanteDTO;
import br.dev.nathan.adocao_pets.entities.AdotanteEntity;
import br.dev.nathan.adocao_pets.exceptions.AdotanteNaoEncontradoException;
import br.dev.nathan.adocao_pets.repositories.AdotanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdotanteService {

    private final AdotanteRepository repository;

    public AdotanteService(AdotanteRepository repository) {
        this.repository = repository;
    }

    public List<AdotanteDTO> listarTudo() {
        return repository.findAll()
            .stream()
            .map(x -> new AdotanteDTO(x))
            .toList();
    }

    public AdotanteDTO buscarPorId(Integer id) {
        return new AdotanteDTO(
            repository.findById(id)
                .orElseThrow(() -> new AdotanteNaoEncontradoException())
        );
    }

    public void inserir(AdotanteDTO dto) {
        repository.save(new AdotanteEntity(dto));
    }

    public void atualizar(AdotanteDTO dto, Integer id) {
        if (repository.existsById(id)) {
            AdotanteEntity entity = new AdotanteEntity(dto);
            entity.setId(id);
            repository.save(entity);
        } else {
            throw new AdotanteNaoEncontradoException();
        }
    }

    public void excluirPorId(Integer id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new AdotanteNaoEncontradoException();
    }
}
