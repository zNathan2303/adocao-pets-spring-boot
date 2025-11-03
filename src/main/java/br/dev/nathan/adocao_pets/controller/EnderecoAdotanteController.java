package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.EnderecoAdotanteDTO;
import br.dev.nathan.adocao_pets.services.EnderecoAdotanteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/adotante/endereco")
@Validated
public class EnderecoAdotanteController {

    private final EnderecoAdotanteService service;

    public EnderecoAdotanteController(EnderecoAdotanteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoAdotanteDTO>> listarTodosEnderecosDosAdotantes() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoAdotanteDTO> buscarEnderecoDeAlgumAdotantePorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> inserirEnderecoDeUmAdotante(@Valid @RequestBody EnderecoAdotanteDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarEnderecoDeUmAdotante(@Valid @RequestBody EnderecoAdotanteDTO dto,
                                                              @PathVariable("id") Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEnderecoPorId(@PathVariable Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
