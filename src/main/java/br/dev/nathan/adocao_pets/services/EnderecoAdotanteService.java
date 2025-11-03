package br.dev.nathan.adocao_pets.services;

import br.dev.nathan.adocao_pets.dtos.EnderecoAdotanteDTO;
import br.dev.nathan.adocao_pets.entities.AdotanteEntity;
import br.dev.nathan.adocao_pets.entities.EnderecoAdotanteEntity;
import br.dev.nathan.adocao_pets.exceptions.AdotanteInexistenteException;
import br.dev.nathan.adocao_pets.exceptions.EnderecoAdotanteNaoEncontradoException;
import br.dev.nathan.adocao_pets.repositories.AdotanteRepository;
import br.dev.nathan.adocao_pets.repositories.EnderecoAdotanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoAdotanteService {

    private final EnderecoAdotanteRepository enderecoAdotanteRepository;
    private final AdotanteRepository adotanteRepository;

    public EnderecoAdotanteService(EnderecoAdotanteRepository enderecoAdotanteRepository,
                                   AdotanteRepository adotanteRepository) {
        this.enderecoAdotanteRepository = enderecoAdotanteRepository;
        this.adotanteRepository = adotanteRepository;
    }

    private EnderecoAdotanteEntity transformarDTOEmEntity(EnderecoAdotanteDTO dto) {
        AdotanteEntity adotante = adotanteRepository.findById(dto.getIdAdotante())
            .orElseThrow(() -> new AdotanteInexistenteException());

        return new EnderecoAdotanteEntity(
            dto.getId(),
            dto.getLogradouro(),
            dto.getNumero(),
            dto.getBairro(),
            dto.getCidade(),
            dto.getEstado(),
            adotante
        );
    }

    public List<EnderecoAdotanteDTO> listarTudo() {
        return enderecoAdotanteRepository.findAll()
            .stream()
            .map(x -> new EnderecoAdotanteDTO(x))
            .toList();
    }

    public EnderecoAdotanteDTO buscarPorId(Integer id) {
        return new EnderecoAdotanteDTO(
            enderecoAdotanteRepository.findById(id)
                .orElseThrow(() -> new EnderecoAdotanteNaoEncontradoException())
        );
    }

    public void inserir(EnderecoAdotanteDTO dto) {
        enderecoAdotanteRepository.save(transformarDTOEmEntity(dto));
    }

    public void atualizar(EnderecoAdotanteDTO dto, Integer id) {
        if (enderecoAdotanteRepository.existsById(id)) {
            EnderecoAdotanteEntity entity = transformarDTOEmEntity(dto);
            entity.setId(id);
            enderecoAdotanteRepository.save(entity);
        } else {
            throw new EnderecoAdotanteNaoEncontradoException();
        }
    }

    public void excluirPorId(Integer id) {
        if (enderecoAdotanteRepository.existsById(id))
            enderecoAdotanteRepository.deleteById(id);
        else
            throw new EnderecoAdotanteNaoEncontradoException();
    }
}
