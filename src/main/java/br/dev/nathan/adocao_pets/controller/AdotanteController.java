package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.AdotanteDTO;
import br.dev.nathan.adocao_pets.services.AdotanteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/adotante")
@Validated
public class AdotanteController {

    private final AdotanteService service;

    public AdotanteController(AdotanteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AdotanteDTO>> listarTodosOsAdotantes() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdotanteDTO> buscarAdotantePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> inserirAdotante(@Valid @RequestBody AdotanteDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarAdotante(@Valid @RequestBody AdotanteDTO dto,
                                                  @PathVariable Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAdotantePorId(@PathVariable Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
