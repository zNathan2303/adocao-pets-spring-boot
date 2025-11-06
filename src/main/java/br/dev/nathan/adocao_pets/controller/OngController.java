package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.EnderecoOngDTO;
import br.dev.nathan.adocao_pets.dtos.OngDTO;
import br.dev.nathan.adocao_pets.dtos.PetDTO;
import br.dev.nathan.adocao_pets.services.OngService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/ong")
@Validated
public class OngController {

    private final OngService service;

    public OngController(OngService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OngDTO>> listarTodasAsOngs() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/ativa")
    public ResponseEntity<List<OngDTO>> listarTodasAsOngsAtivas() {
        return ResponseEntity.ok(service.listarOngsAtivas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OngDTO> buscarOngPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/{id}/pet")
    public ResponseEntity<List<PetDTO>> listarTodosOsPetsDeUmaOng(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.listarPetsDeUmaOng(id));
    }

    @GetMapping("/{id}/endereco")
    public ResponseEntity<List<EnderecoOngDTO>> listarTodosOsEnderecosDeUmaOng(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.listarEnderecosDeUmaOng(id));
    }

    @PostMapping
    public ResponseEntity<Void> inserirOng(@Valid @RequestBody OngDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarOng(@Valid @RequestBody OngDTO dto,
                                             @PathVariable("id") Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirOngPorId(@PathVariable("id") Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
