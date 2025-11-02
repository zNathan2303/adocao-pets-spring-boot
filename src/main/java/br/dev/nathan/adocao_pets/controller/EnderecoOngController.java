package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.EnderecoOngDTO;
import br.dev.nathan.adocao_pets.services.EnderecoOngService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ong/endereco")
@Validated
public class EnderecoOngController {

    private final EnderecoOngService service;

    public EnderecoOngController(EnderecoOngService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoOngDTO>> listarTodosOsEnderecosDasOngs() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoOngDTO> buscarEnderecoDeAlgumaOngPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> inserirEnderecoDeUmaOng(@Valid @RequestBody EnderecoOngDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarEnderecoDeUmaOng(@Valid @RequestBody EnderecoOngDTO dto,
                                                          @PathVariable("id") Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEnderecoPorId(@PathVariable("id") Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
