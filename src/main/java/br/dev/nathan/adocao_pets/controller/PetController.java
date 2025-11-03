package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.PetDTO;
import br.dev.nathan.adocao_pets.services.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pet")
@Validated
public class PetController {

    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> listarTodosPets() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> buscarPetPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> inserirPet(@Valid @RequestBody PetDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPet(@Valid @RequestBody PetDTO dto,
                                             @PathVariable Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPetPorId(@PathVariable Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
