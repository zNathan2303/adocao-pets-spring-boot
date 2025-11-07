package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.EnderecoOngDTO;
import br.dev.nathan.adocao_pets.dtos.OngDTO;
import br.dev.nathan.adocao_pets.dtos.PetDTO;
import br.dev.nathan.adocao_pets.services.OngService;
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
@RequestMapping("/v1/ong")
@Validated
@Tag(name = "ONG", description = "Gerenciar ONGs cadastradas")
public class OngController {

    private final OngService service;

    public OngController(OngService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Listar ONGs",
        description = "Lista todas as ONGs cadastradas."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!")
    })
    public ResponseEntity<List<OngDTO>> listarTodasAsOngs() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/ativa")
    @Operation(
        summary = "Listar ONGs ativas",
        description = "Lista todas as ONGs cadastradas que estão ativas."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!")
    })
    public ResponseEntity<List<OngDTO>> listarTodasAsOngsAtivas() {
        return ResponseEntity.ok(service.listarOngsAtivas());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar uma ONG",
        description = "Busca uma ONG por id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "ONG não encontrada!", content = @Content())
    })
    public ResponseEntity<OngDTO> buscarOngPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/{id}/pet")
    @Operation(
        summary = "Listar pets",
        description = "Lista todos os pets resgatados por uma determinada ONG."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "ONG não encontrada!", content = @Content())
    })
    public ResponseEntity<List<PetDTO>> listarTodosOsPetsDeUmaOng(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.listarPetsDeUmaOng(id));
    }

    @GetMapping("/{id}/endereco")
    @Operation(
        summary = "Listar endereços",
        description = "Lista todos os endereços que uma determinada ONG possui."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "ONG não encontrada!", content = @Content())
    })
    public ResponseEntity<List<EnderecoOngDTO>> listarTodosOsEnderecosDeUmaOng(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.listarEnderecosDeUmaOng(id));
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar ONG",
        description = "Cadastra uma nova ONG."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "a data é inexistente/formato é inválido " +
                "ou algum dos campos está inválido!")
    })
    public ResponseEntity<Void> inserirOng(@Valid @RequestBody OngDTO dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar ONG",
        description = "Atualiza uma ONG cadastrada."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atualizado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "a data é inexistente/formato é inválido " +
                "ou algum dos campos está inválido!"),
        @ApiResponse(responseCode = "404", description = "ONG não encontrada!")
    })
    public ResponseEntity<Void> atualizarOng(@Valid @RequestBody OngDTO dto,
                                             @PathVariable("id") Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Excluir ONG",
        description = "Exclui uma ONG cadastrada pelo id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "ONG excluída com sucesso!"),
        @ApiResponse(responseCode = "404", description = "ONG não encontrada!")
    })
    public ResponseEntity<Void> excluirOngPorId(@PathVariable("id") Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
