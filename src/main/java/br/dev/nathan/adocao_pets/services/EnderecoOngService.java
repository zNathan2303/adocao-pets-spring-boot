package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.EnderecoOngDTO;
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

    public EnderecoOngService(EnderecoOngRepository enderecoOngRepository, OngRepository ongRepository) {
        this.enderecoOngRepository = enderecoOngRepository;
        this.ongRepository = ongRepository;
    }

    private EnderecoOngEntity transformarDTOEmEntity (EnderecoOngDTO dto) {
        OngEntity ong = ongRepository.findById(dto.getIdOng())
                .orElseThrow(() -> new OngInexistenteException());

        return new EnderecoOngEntity(
            dto.getId(),
            dto.getLogradouro(),
            dto.getNumero(),
            dto.getBairro(),
            dto.getCidade(),
            dto.getEstado(),
            dto.getInscricaoMunicipal(),
            ong
        );
    }

    public List<EnderecoOngDTO> listarTudo() {
        return enderecoOngRepository.findAll().stream().map(x -> new EnderecoOngDTO(x)).toList();
    }

    public EnderecoOngDTO buscarPorId(Integer id) {
        return new EnderecoOngDTO(enderecoOngRepository.findById(id)
            .orElseThrow(() -> new EnderecoOngNaoEncontradoException()));
    }

    public void inserir(EnderecoOngDTO dto) {
        enderecoOngRepository.save(transformarDTOEmEntity(dto));
    }

    public void atualizar(EnderecoOngDTO dto, Integer id) {
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
