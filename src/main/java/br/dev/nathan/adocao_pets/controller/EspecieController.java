package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.requests.EspecieRequest;
import br.dev.nathan.adocao_pets.dtos.responses.EspecieResponse;
import br.dev.nathan.adocao_pets.services.EspecieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/especie")
@Validated
@Tag(name = "Espécie", description = "Gerenciar espécies cadastradas")
public class EspecieController {

    private final EspecieService service;

    public EspecieController(EspecieService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Listar espécies",
        description = "Lista todas as espécies já cadastradas."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!")
    })
    public ResponseEntity<List<EspecieResponse>> listarTodasEspecies() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar uma espécie",
        description = "Busca uma espécie por id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "Espécie não encontrada!", content = @Content())
    })
    public ResponseEntity<EspecieResponse> buscarEspeciePorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar uma espécie",
        description = "Cadastra uma nova espécie."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Registrado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado ou " +
                "o nome está inválido!")
    })
    public ResponseEntity<Void> inserirEspecie(@Valid @RequestBody EspecieRequest dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar espécie",
        description = "Atualiza uma espécie cadastrada."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atualizado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado ou " +
                "o nome está inválido!"),
        @ApiResponse(responseCode = "404", description = "Espécie não encontrada!")
    })
    public ResponseEntity<Void> atualizarEspecie(@Valid @RequestBody EspecieRequest dto,
                                                 @PathVariable("id") Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Excluir espécie",
        description = "Exclui uma espécie cadastrada pelo id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Espécie excluída com sucesso!"),
        @ApiResponse(responseCode = "404", description = "Espécie não encontrada!")
    })
    public ResponseEntity<Void> excluirEspeciePorId(@PathVariable("id") Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
