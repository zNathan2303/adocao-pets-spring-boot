package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.RacaDTO;
import br.dev.nathan.adocao_pets.services.RacaService;
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
@RequestMapping("/v1/raca")
@Validated
@Tag(name = "Raça", description = "Gerenciar as raças de pets")
public class RacaController {

    private final RacaService service;

    public RacaController(RacaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Listar raças",
        description = "Lista todas as raças cadastradas."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!")
    })
    public ResponseEntity<List<RacaDTO>> listarTodasAsRacas() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar uma raça",
        description = "Busca uma raça por id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "Raça não encontrada!", content = @Content())
    })
    public ResponseEntity<RacaDTO> buscarRacaPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar raça",
        description = "Cadastra uma nova raça."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "algum dos campos está inválido " +
                "ou a espécie informada não existe!")
    })
    public ResponseEntity<Void> inserirRaca(@Valid @RequestBody RacaDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar raça",
        description = "Atualiza uma raça cadastrada."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cadastrado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "algum dos campos está inválido " +
                "ou a espécie informada não existe!"),
        @ApiResponse(responseCode = "404", description = "Raça não encontrada!")
    })
    public ResponseEntity<Void> atualizarRaca(@Valid @RequestBody RacaDTO dto,
                                              @PathVariable("id") Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Excluir raça",
        description = "Exclui uma raça cadastrada."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Raça excluída com sucesso!"),
        @ApiResponse(responseCode = "404", description = "Raça não encontrada!")
    })
    public ResponseEntity<Void> excluirRacaPorId(@PathVariable("id") Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
