package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.EspecieDTO;
import br.dev.nathan.adocao_pets.entities.EspecieEntity;
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
        return new EspecieDTO(repository.findById(id).orElseThrow());
    }
    
    public void inserir(EspecieDTO dto) {
        repository.save(new EspecieEntity(dto));
    }

    public void atualizar(EspecieDTO dto, Integer id) {
        EspecieEntity entity = new EspecieEntity(dto);
        entity.setId(id);
        repository.save(entity);
    }

    public void excluirPorId(Integer id) {
        repository.deleteById(id);
    }

}
