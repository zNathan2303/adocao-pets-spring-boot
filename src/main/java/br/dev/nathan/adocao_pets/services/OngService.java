package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.requests.OngRequest;
import br.dev.nathan.adocao_pets.dtos.responses.EnderecoOngResponse;
import br.dev.nathan.adocao_pets.dtos.responses.OngResponse;
import br.dev.nathan.adocao_pets.dtos.responses.PetResponse;
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

    public List<OngResponse> listarOngsAtivas() {
        return repository.listarOngsAtivas()
            .stream()
            .map(x -> new OngResponse(x))
            .toList();
    }

    public List<PetResponse> listarPetsDeUmaOng(Integer ongId) {
        if (!repository.existsById(ongId))
            throw new OngNaoEncontradaException();

        return repository.listarPetsDeUmaOng(ongId)
            .stream()
            .map(x -> new PetResponse(x))
            .toList();
    }

    public List<EnderecoOngResponse> listarEnderecosDeUmaOng(Integer ongId) {
        if (!repository.existsById(ongId))
            throw new OngNaoEncontradaException();

        return repository.listarEnderecosDeUmaOng(ongId)
            .stream()
            .map(x -> new EnderecoOngResponse(x))
            .toList();
    }

    /*
    * OPERAÇÕES CRUD
    * */

    public List<OngResponse> listarTudo() {
        return repository.findAll()
            .stream()
            .map(x -> new OngResponse(x))
            .toList();
    }

    public OngResponse buscarPorId(Integer id) {
        return new OngResponse(
            repository.findById(id)
                .orElseThrow(() -> new OngNaoEncontradaException())
        );
    }

    public void inserir(OngRequest dto) {
        repository.save(new OngEntity(dto));
    }

    public void atualizar(OngRequest dto, Integer id) {
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
