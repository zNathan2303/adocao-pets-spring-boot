package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.requests.AdotanteRequest;
import br.dev.nathan.adocao_pets.dtos.responses.AdotanteResponse;
import br.dev.nathan.adocao_pets.dtos.responses.EnderecoAdotanteResponse;
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

    /*
     * OPERAÇÕES PERSONALIZADAS
     * */

    public List<EnderecoAdotanteResponse> listarEnderecosDeUmAdotante(Integer id) {
        if (!repository.existsById(id))
            throw new AdotanteNaoEncontradoException();

        return repository.listarEnderecosDeUmAdotante(id)
            .stream()
            .map(x -> new EnderecoAdotanteResponse(x))
            .toList();
    }

    /*
     * OPERAÇÕES CRUD
     * */

    public List<AdotanteResponse> listarTudo() {
        return repository.findAll()
            .stream()
            .map(x -> new AdotanteResponse(x))
            .toList();
    }

    public AdotanteResponse buscarPorId(Integer id) {
        return new AdotanteResponse(
            repository.findById(id)
                .orElseThrow(() -> new AdotanteNaoEncontradoException())
        );
    }

    public void inserir(AdotanteRequest dto) {
        repository.save(new AdotanteEntity(dto));
    }

    public void atualizar(AdotanteRequest dto, Integer id) {
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
