package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.AdocaoDTO;
import br.dev.nathan.adocao_pets.services.AdocaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/adocao")
@Validated
public class AdocaoController {

    private final AdocaoService service;

    public AdocaoController(AdocaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AdocaoDTO>> listarTodasAdocoes() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdocaoDTO> buscarAdocaoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> inserirAdocao(@Valid @RequestBody AdocaoDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarAdocao(@Valid @RequestBody AdocaoDTO dto,
                                                @PathVariable Integer id) {
        service.atualizar(dto,id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAdocaoPorId(@PathVariable Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
