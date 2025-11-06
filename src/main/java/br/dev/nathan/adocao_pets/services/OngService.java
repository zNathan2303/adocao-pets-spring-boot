package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.EnderecoOngDTO;
import br.dev.nathan.adocao_pets.dtos.OngDTO;
import br.dev.nathan.adocao_pets.dtos.PetDTO;
import br.dev.nathan.adocao_pets.entities.OngEntity;
import br.dev.nathan.adocao_pets.exceptions.OngNaoEncontradaException;
import br.dev.nathan.adocao_pets.repositories.OngRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OngService {

    private final OngRepository repository;

    public OngService(OngRepository repository) {
        this.repository = repository;
    }

    /*
    * OPERAÇÕES PERSONALIZADAS
    * */

    public List<OngDTO> listarOngsAtivas() {
        return repository.listarOngsAtivas()
            .stream()
            .map(x -> new OngDTO(x))
            .toList();
    }

    public List<PetDTO> listarPetsDeUmaOng(Integer ongId) {
        if (!repository.existsById(ongId))
            throw new OngNaoEncontradaException();

        return repository.listarPetsDeUmaOng(ongId)
            .stream()
            .map(x -> new PetDTO(x))
            .toList();
    }

    public List<EnderecoOngDTO> listarEnderecosDeUmaOng(Integer ongId) {
        if (!repository.existsById(ongId))
            throw new OngNaoEncontradaException();

        return repository.listarEnderecosDeUmaOng(ongId)
            .stream()
            .map(x -> new EnderecoOngDTO(x))
            .toList();
    }

    /*
    * OPERAÇÕES CRUD
    * */

    public List<OngDTO> listarTudo() {
        return repository.findAll()
            .stream()
            .map(x -> new OngDTO(x))
            .toList();
    }

    public OngDTO buscarPorId(Integer id) {
        return new OngDTO(
            repository.findById(id)
                .orElseThrow(() -> new OngNaoEncontradaException())
        );
    }

    public void inserir(OngDTO dto) {
        repository.save(new OngEntity(dto));
    }

    public void atualizar(OngDTO dto, Integer id) {
        if (repository.existsById(id)) {
            OngEntity entity = new OngEntity(dto);
            entity.setId(id);
            repository.save(entity);
        } else {
            throw new OngNaoEncontradaException();
        }
    }

    public void excluirPorId(Integer id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new OngNaoEncontradaException();
    }
}
