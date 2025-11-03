package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.AdocaoDTO;
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

    private AdocaoEntity transformarDTOEmEntity(AdocaoDTO dto) {
        AdotanteEntity adotante = adotanteRepository.findById(dto.getIdAdotante())
            .orElseThrow(() -> new AdotanteInexistenteException());
        PetEntity pet = petRepository.findById(dto.getIdPet())
            .orElseThrow(() -> new PetInexistenteException());

        return new AdocaoEntity(
            dto.getId(),
            dto.getDataAdocao(),
            adotante,
            pet
        );
    }

    public List<AdocaoDTO> listarTudo() {
        return adocaoRepository.findAll()
            .stream()
            .map(x -> new AdocaoDTO(x))
            .toList();
    }

    public AdocaoDTO buscarPorId(Integer id) {
        return new AdocaoDTO(
            adocaoRepository.findById(id)
                .orElseThrow(() -> new AdocaoNaoEncontradaException())
        );
    }

    public void inserir(AdocaoDTO dto) {
        if (adocaoRepository.existeAdocaoComIdDoPet(dto.getIdPet()) == 0)
            adocaoRepository.save(transformarDTOEmEntity(dto));
        else
            throw new PetAdotadoException();
    }

    public void atualizar(AdocaoDTO dto, Integer id) {

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
