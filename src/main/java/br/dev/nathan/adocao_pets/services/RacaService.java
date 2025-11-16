package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.requests.RacaRequest;
import br.dev.nathan.adocao_pets.dtos.responses.RacaResponse;
import br.dev.nathan.adocao_pets.entities.EspecieEntity;
import br.dev.nathan.adocao_pets.entities.RacaEntity;
import br.dev.nathan.adocao_pets.exceptions.EspecieInexistenteException;
import br.dev.nathan.adocao_pets.exceptions.RacaNaoEncontradaException;
import br.dev.nathan.adocao_pets.repositories.EspecieRepository;
import br.dev.nathan.adocao_pets.repositories.RacaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacaService {

    private final RacaRepository racaRepository;
    private final EspecieRepository especieRepository;

    public RacaService(RacaRepository racaRepository, EspecieRepository especieRepository) {
        this.racaRepository = racaRepository;
        this.especieRepository = especieRepository;
    }

    private RacaEntity transformarDTOEmEntity(RacaRequest dto) {

        EspecieEntity especie = especieRepository.findById(dto.getIdEspecie())
            .orElseThrow(() -> new EspecieInexistenteException());

        return new RacaEntity(
            null,
            dto.getNome(),
            especie
        );
    }

    public List<RacaResponse> listarTudo() {
        return racaRepository.findAll()
            .stream()
            .map(x -> new RacaResponse(x))
            .toList();
    }

    public RacaResponse buscarPorId(Integer id) {
        return new RacaResponse(
            racaRepository.findById(id)
                .orElseThrow(() -> new RacaNaoEncontradaException())
        );
    }

    public void inserir(RacaRequest dto) {
        racaRepository.save(transformarDTOEmEntity(dto));
    }

    public void atualizar(RacaRequest dto, Integer id) {
        if (racaRepository.existsById(id)) {
            RacaEntity entity = transformarDTOEmEntity(dto);
            entity.setId(id);
            racaRepository.save(entity);
        } else {
            throw new RacaNaoEncontradaException();
        }
    }

    public void excluirPorId(Integer id) {
        if (racaRepository.existsById(id))
            racaRepository.deleteById(id);
        else
            throw new RacaNaoEncontradaException();
    }
}
