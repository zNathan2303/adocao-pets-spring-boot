package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.PetDTO;
import br.dev.nathan.adocao_pets.services.PetService;
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
@RequestMapping("/v1/pet")
@Validated
@Tag(name = "Pet", description = "Gerenciar os pets cadastrados")
public class PetController {

    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Listar pets",
        description = "Listar todos os pets cadastrados."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!")
    })
    public ResponseEntity<List<PetDTO>> listarTodosPets() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar um pet",
        description = "Busca um pet por id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "Pet não encontrado!", content = @Content())
    })
    public ResponseEntity<PetDTO> buscarPetPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar um pet",
        description = "Cadastra um novo pet."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "algum dos campos está inválido, " +
                "o pet informado já foi adotado, " +
                "ONG informada não existe " +
                "ou raça informada não existe!")
    })
    public ResponseEntity<Void> inserirPet(@Valid @RequestBody PetDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar pet",
        description = "Atualiza um pet cadastrado."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atualizado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "algum dos campos está inválido, " +
                "o pet informado já foi adotado, " +
                "ONG informada não existe " +
                "ou raça informada não existe!"),
        @ApiResponse(responseCode = "404", description = "Pet não encontrado!")
    })
    public ResponseEntity<Void> atualizarPet(@Valid @RequestBody PetDTO dto,
                                             @PathVariable Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Excluir pet",
        description = "Exclui um pet cadastrado pelo id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pet excluído com sucesso!"),
        @ApiResponse(responseCode = "404", description = "Pet não encontrado!")
    })
    public ResponseEntity<Void> excluirPetPorId(@PathVariable Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
