package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.requests.EnderecoAdotanteRequest;
import br.dev.nathan.adocao_pets.dtos.responses.EnderecoAdotanteResponse;
import br.dev.nathan.adocao_pets.services.EnderecoAdotanteService;
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
@RequestMapping("/v1/adotante/endereco")
@Validated
@Tag(name = "Endereço do adotante", description = "Gerenciar os endereços dos adotantes")
public class EnderecoAdotanteController {

    private final EnderecoAdotanteService service;

    public EnderecoAdotanteController(EnderecoAdotanteService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Listar endereços",
        description = "Lista todos os endereços de adotantes cadastrados."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!")
    })
    public ResponseEntity<List<EnderecoAdotanteResponse>> listarTodosEnderecosDosAdotantes() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar um endereço",
        description = "Busca um endereço de adotante por id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "Endereço do adotante não encontrado!", content = @Content())
    })
    public ResponseEntity<EnderecoAdotanteResponse> buscarEnderecoDeAlgumAdotantePorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar endereço",
        description = "Cadastra um endereço de um adotante."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "o adotante informado não existe " +
                "ou algum dos campos está inválido!")
    })
    public ResponseEntity<Void> inserirEnderecoDeUmAdotante(@Valid @RequestBody EnderecoAdotanteRequest dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar endereço",
        description = "Atualiza um endereço de um adotante já cadastrado."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atualizado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "o adotante informado não existe " +
                "ou algum dos campos está inválido"),
        @ApiResponse(responseCode = "404", description = "Endereço do adotante não encontrado!")
    })
    public ResponseEntity<Void> atualizarEnderecoDeUmAdotante(@Valid @RequestBody EnderecoAdotanteRequest dto,
                                                              @PathVariable("id") Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Apagar endereço",
        description = "Apaga um endereço de um adotante pelo id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Endereço apagado com sucesso!"),
        @ApiResponse(responseCode = "404", description = "Endereço do adotante não encontrado!")
    })
    public ResponseEntity<Void> excluirEnderecoPorId(@PathVariable Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
