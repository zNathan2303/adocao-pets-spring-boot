package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.EspecieDTO;
import br.dev.nathan.adocao_pets.services.EspecieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/especie")
public class EspecieController {

    private final EspecieService service;

    public EspecieController(EspecieService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EspecieDTO>> listarTodasEspecies() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecieDTO> buscarEspeciePorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> inserirEspecie(@RequestBody EspecieDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarEspecie(@RequestBody EspecieDTO dto,
                                                 @PathVariable("id") Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEspeciePorId(@PathVariable("id") Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
