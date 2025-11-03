package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.PetDTO;
import br.dev.nathan.adocao_pets.entities.OngEntity;
import br.dev.nathan.adocao_pets.entities.PetEntity;
import br.dev.nathan.adocao_pets.entities.RacaEntity;
import br.dev.nathan.adocao_pets.exceptions.OngInexistenteException;
import br.dev.nathan.adocao_pets.exceptions.PetNaoEncontradoException;
import br.dev.nathan.adocao_pets.exceptions.RacaInexistenteException;
import br.dev.nathan.adocao_pets.repositories.OngRepository;
import br.dev.nathan.adocao_pets.repositories.PetRepository;
import br.dev.nathan.adocao_pets.repositories.RacaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final OngRepository ongRepository;
    private final RacaRepository racaRepository;

    public PetService(PetRepository petRepository, OngRepository ongRepository,
                      RacaRepository racaRepository) {
        this.petRepository = petRepository;
        this.ongRepository = ongRepository;
        this.racaRepository = racaRepository;
    }

    private PetEntity transformarDTOEmEntity(PetDTO dto) {
        OngEntity ong = ongRepository.findById(dto.getIdOng())
            .orElseThrow(() -> new OngInexistenteException());

        RacaEntity raca = racaRepository.findById(dto.getIdRaca())
            .orElseThrow(() -> new RacaInexistenteException());

        return new PetEntity(
            dto.getId(),
            dto.getNome(),
            dto.getFotoUrl(),
            dto.getIdadeAproximada(),
            dto.getPorte(),
            dto.getSexo(),
            dto.getDescricao(),
            raca,
            ong
        );
    }

    public List<PetDTO> listarTudo() {
        return petRepository.findAll()
            .stream()
            .map(x -> new PetDTO(x))
            .toList();
    }

    public PetDTO buscarPorId(Integer id) {
        return new PetDTO(
            petRepository.findById(id)
                .orElseThrow(() -> new PetNaoEncontradoException())
        );
    }

    public void inserir(PetDTO dto) {
        petRepository.save(transformarDTOEmEntity(dto));
    }

    public void atualizar(PetDTO dto, Integer id) {
        if (petRepository.existsById(id)) {
            PetEntity entity = transformarDTOEmEntity(dto);
            entity.setId(id);
            petRepository.save(entity);
        } else {
            throw new PetNaoEncontradoException();
        }
    }

    public void excluirPorId(Integer id) {
        if (petRepository.existsById(id))
            petRepository.deleteById(id);
        else
            throw new PetNaoEncontradoException();
    }
}
