package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.requests.EnderecoOngRequest;
import br.dev.nathan.adocao_pets.dtos.responses.EnderecoOngResponse;
import br.dev.nathan.adocao_pets.entities.EnderecoOngEntity;
import br.dev.nathan.adocao_pets.entities.OngEntity;
import br.dev.nathan.adocao_pets.exceptions.EnderecoOngNaoEncontradoException;
import br.dev.nathan.adocao_pets.exceptions.OngInexistenteException;
import br.dev.nathan.adocao_pets.repositories.EnderecoOngRepository;
import br.dev.nathan.adocao_pets.repositories.OngRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoOngService {

    private final EnderecoOngRepository enderecoOngRepository;
    private final OngRepository ongRepository;

    public EnderecoOngService(EnderecoOngRepository enderecoOngRepository,
                              OngRepository ongRepository) {
        this.enderecoOngRepository = enderecoOngRepository;
        this.ongRepository = ongRepository;
    }

    private EnderecoOngEntity transformarDTOEmEntity (EnderecoOngRequest dto) {
        OngEntity ong = ongRepository.findById(dto.getIdOng())
            .orElseThrow(() -> new OngInexistenteException());

        return new EnderecoOngEntity(
            null,
            dto.getLogradouro(),
            dto.getNumero(),
            dto.getBairro(),
            dto.getCidade(),
            dto.getEstado(),
            dto.getInscricaoMunicipal(),
            ong
        );
    }

    public List<EnderecoOngResponse> listarTudo() {
        return enderecoOngRepository.findAll()
            .stream()
            .map(x -> new EnderecoOngResponse(x))
            .toList();
    }

    public EnderecoOngResponse buscarPorId(Integer id) {
        return new EnderecoOngResponse(
            enderecoOngRepository.findById(id)
                .orElseThrow(() -> new EnderecoOngNaoEncontradoException())
        );
    }

    public void inserir(EnderecoOngRequest dto) {
        enderecoOngRepository.save(transformarDTOEmEntity(dto));
    }

    public void atualizar(EnderecoOngRequest dto, Integer id) {
        if (enderecoOngRepository.existsById(id)) {
            EnderecoOngEntity entity = transformarDTOEmEntity(dto);
            entity.setId(id);
            enderecoOngRepository.save(entity);
        } else {
            throw new EnderecoOngNaoEncontradoException();
        }
    }

    public void excluirPorId(Integer id) {
        if (enderecoOngRepository.existsById(id))
            enderecoOngRepository.deleteById(id);
        else
            throw new EnderecoOngNaoEncontradoException();
    }
}
