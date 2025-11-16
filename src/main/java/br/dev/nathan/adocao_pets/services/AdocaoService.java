package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.requests.AdocaoRequest;
import br.dev.nathan.adocao_pets.dtos.responses.AdocaoResponse;
import br.dev.nathan.adocao_pets.entities.AdocaoEntity;
import br.dev.nathan.adocao_pets.entities.AdotanteEntity;
import br.dev.nathan.adocao_pets.entities.PetEntity;
import br.dev.nathan.adocao_pets.exceptions.AdocaoNaoEncontradaException;
import br.dev.nathan.adocao_pets.exceptions.AdotanteInexistenteException;
import br.dev.nathan.adocao_pets.exceptions.PetAdotadoException;
import br.dev.nathan.adocao_pets.exceptions.PetInexistenteException;
import br.dev.nathan.adocao_pets.repositories.AdocaoRepository;
import br.dev.nathan.adocao_pets.repositories.AdotanteRepository;
import br.dev.nathan.adocao_pets.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdocaoService {

    private final AdocaoRepository adocaoRepository;
    private final AdotanteRepository adotanteRepository;
    private final PetRepository petRepository;

    public AdocaoService(AdocaoRepository adocaoRepository, AdotanteRepository adotanteRepository, PetRepository petRepository) {
        this.adocaoRepository = adocaoRepository;
        this.adotanteRepository = adotanteRepository;
        this.petRepository = petRepository;
    }

    private AdocaoEntity transformarDTOEmEntity(AdocaoRequest dto) {
        AdotanteEntity adotante = adotanteRepository.findById(dto.getIdAdotante())
            .orElseThrow(() -> new AdotanteInexistenteException());
        PetEntity pet = petRepository.findById(dto.getIdPet())
            .orElseThrow(() -> new PetInexistenteException());

        return new AdocaoEntity(
            null,
            dto.getDataAdocao(),
            adotante,
            pet
        );
    }

    public List<AdocaoResponse> listarTudo() {
        return adocaoRepository.findAll()
            .stream()
            .map(x -> new AdocaoResponse(x))
            .toList();
    }

    public AdocaoResponse buscarPorId(Integer id) {
        return new AdocaoResponse(
            adocaoRepository.findById(id)
                .orElseThrow(() -> new AdocaoNaoEncontradaException())
        );
    }

    public void inserir(AdocaoRequest dto) {
        if (adocaoRepository.existeAdocaoComIdDoPet(dto.getIdPet()) == 0)
            adocaoRepository.save(transformarDTOEmEntity(dto));
        else
            throw new PetAdotadoException();
    }

    public void atualizar(AdocaoRequest dto, Integer id) {

        if (adocaoRepository.existeAdocaoComIdDoPet(dto.getIdPet()) == 1)
            throw new PetAdotadoException();

        if (adocaoRepository.existsById(id)){
            AdocaoEntity entity = transformarDTOEmEntity(dto);
            entity.setId(id);
            adocaoRepository.save(entity);
        } else {
            throw new AdocaoNaoEncontradaException();
        }
    }

    public void excluirPorId(Integer id) {
        if (adocaoRepository.existsById(id))
            adocaoRepository.deleteById(id);
        else
            throw new AdocaoNaoEncontradaException();
    }
}
