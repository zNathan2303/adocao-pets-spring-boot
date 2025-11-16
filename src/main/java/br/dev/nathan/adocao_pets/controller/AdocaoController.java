package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.requests.AdocaoRequest;
import br.dev.nathan.adocao_pets.dtos.responses.AdocaoResponse;
import br.dev.nathan.adocao_pets.services.AdocaoService;
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
@RequestMapping("/v1/adocao")
@Validated
@Tag(name = "Adoção", description = "Gerenciar as adoções de pets")
public class AdocaoController {

    private final AdocaoService service;

    public AdocaoController(AdocaoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Listar adoções",
        description = "Lista todas as adoções que já ocorreram."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!")
    })
    public ResponseEntity<List<AdocaoResponse>> listarTodasAdocoes() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar uma adoção",
        description = "Busca uma adoção por id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "Adoção não encontrada!", content = @Content())
    })
    public ResponseEntity<AdocaoResponse> buscarAdocaoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(
        summary = "Registrar adoção",
        description = "Registra uma nova adoção que ocorreu."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Registrado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "a data é inexistente/formato é inválido, " +
                "algum dos campos está inválido, " +
                "ou o pet informado já foi adotado!")
    })
    public ResponseEntity<Void> inserirAdocao(@Valid @RequestBody AdocaoRequest dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar adoção",
        description = "Atualiza uma adoção que já ocorreu."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atualizado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "a data é inexistente/formato é inválido, " +
                "algum dos campos está inválido, " +
                "ou o pet informado já foi adotado!"),
        @ApiResponse(responseCode = "404", description = "Adoção não encontrada!")
    })
    public ResponseEntity<Void> atualizarAdocao(@Valid @RequestBody AdocaoRequest dto,
                                                @PathVariable Integer id) {
        service.atualizar(dto,id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Excluir adoção",
        description = "Exclui uma adoção que já ocorreu pelo id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Adoção excluída com sucesso!"),
        @ApiResponse(responseCode = "404", description = "Adoção não encontrada!")
    })
    public ResponseEntity<Void> excluirAdocaoPorId(@PathVariable Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
