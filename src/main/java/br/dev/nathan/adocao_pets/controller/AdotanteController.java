package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.AdotanteDTO;
import br.dev.nathan.adocao_pets.services.AdotanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/adotante")
@Validated
@Tag(name = "Adotante", description = "Gerenciar os adotantes cadastrados")
public class AdotanteController {

    private final AdotanteService service;

    public AdotanteController(AdotanteService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Listar adotantes",
        description = "Lista todos os adotantes cadastrados."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!")
    })
    public ResponseEntity<List<AdotanteDTO>> listarTodosOsAdotantes() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar um adotante",
        description = "Busca um adotante por id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "Adotante não encontrado!", content = @Content())
    })
    public ResponseEntity<AdotanteDTO> buscarAdotantePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(
        summary = "Cadastra um adotante",
        description = "Cadastra um novo adotante."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado " +
                "ou algum dos campos está inválido!")
    })
    public ResponseEntity<Void> inserirAdotante(@Valid @RequestBody AdotanteDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar adotante",
        description = "Atualiza um adotante cadastrado."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atualizado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado " +
                "ou algum dos campos está inválido!"),
        @ApiResponse(responseCode = "404", description = "Adotante não encontrado!")
    })
    public ResponseEntity<Void> atualizarAdotante(@Valid @RequestBody AdotanteDTO dto,
                                                  @PathVariable Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Apagar adotante",
        description = "Apaga um adotante cadastrado."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Adotante excluído com sucesso!"),
        @ApiResponse(responseCode = "404", description = "Adotante não encontrado!")
    })
    public ResponseEntity<Void> excluirAdotantePorId(@PathVariable Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
