package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.requests.EspecieRequest;
import br.dev.nathan.adocao_pets.dtos.responses.EspecieResponse;
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

    public List<EspecieResponse> listarTudo() {
        return repository.findAll()
            .stream()
            .map(x -> new EspecieResponse(x))
            .toList();
    }

    public EspecieResponse buscarPorId(Integer id) {
        return new EspecieResponse(
            repository.findById(id)
                .orElseThrow(() -> new EspecieNaoEncontradaException())
        );
    }
    
    public void inserir(EspecieRequest dto) {
        repository.save(new EspecieEntity(dto));
    }

    public void atualizar(EspecieRequest dto, Integer id) {
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
