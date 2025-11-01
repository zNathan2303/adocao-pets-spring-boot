package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.EspecieDTO;
import br.dev.nathan.adocao_pets.entities.EspecieEntity;
import br.dev.nathan.adocao_pets.exceptions.EspecieNaoEncontradaException;
import br.dev.nathan.adocao_pets.repositories.EspecieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieService {

    private final EspecieRepository repository;

    public EspecieService(EspecieRepository repository) {
        this.repository = repository;
    }

    public List<EspecieDTO> listarTudo() {
        return repository.findAll().stream().map(x -> new EspecieDTO(x)).toList();
    }

    public EspecieDTO buscarPorId(Integer id) {
        return new EspecieDTO(repository.findById(id).orElseThrow(() -> new EspecieNaoEncontradaException()));
    }
    
    public void inserir(EspecieDTO dto) {
        repository.save(new EspecieEntity(dto));
    }

    public void atualizar(EspecieDTO dto, Integer id) {
        if (repository.existsById(id)) {
            EspecieEntity entity = new EspecieEntity(dto);
            entity.setId(id);
            repository.save(entity);
        } else {
            throw new EspecieNaoEncontradaException();
        }
    }

    public void excluirPorId(Integer id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EspecieNaoEncontradaException();
    }

}
