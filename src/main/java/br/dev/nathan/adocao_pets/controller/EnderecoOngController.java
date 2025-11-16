package br.dev.nathan.adocao_pets.controller;

import br.dev.nathan.adocao_pets.dtos.requests.EnderecoOngRequest;
import br.dev.nathan.adocao_pets.dtos.responses.EnderecoOngResponse;
import br.dev.nathan.adocao_pets.services.EnderecoOngService;
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
@RequestMapping("/v1/ong/endereco")
@Validated
@Tag(name = "Endereço de ONG", description = "Gerenciar os endereços das ONGs")
public class EnderecoOngController {

    private final EnderecoOngService service;

    public EnderecoOngController(EnderecoOngService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Listar endereços",
        description = "Lista todos os endereços de ONGs cadastrados."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!")
    })
    public ResponseEntity<List<EnderecoOngResponse>> listarTodosOsEnderecosDasOngs() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar um endereço",
        description = "Busca um endereço de ONG por id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso!"),
        @ApiResponse(responseCode = "404", description = "Endereço da ONG não encontrado!", content = @Content())
    })
    public ResponseEntity<EnderecoOngResponse> buscarEnderecoDeAlgumaOngPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar endereço",
        description = "Cadastra um endereço de uma ONG."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "a ONG informada não existe " +
                "ou algum dos campos está inválido!")
    })
    public ResponseEntity<Void> inserirEnderecoDeUmaOng(@Valid @RequestBody EnderecoOngRequest dto) {
        service.inserir(dto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar endereço",
        description = "Atualiza um endereço de uma ONG já cadastrado."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atualizado com sucesso!"),
        @ApiResponse(responseCode = "400",
            description = "O corpo da requisição está mal formulado, " +
                "a ONG informado não existe " +
                "ou algum dos campos está inválido"),
        @ApiResponse(responseCode = "404", description = "Endereço da ONG não encontrado!")
    })
    public ResponseEntity<Void> atualizarEnderecoDeUmaOng(@Valid @RequestBody EnderecoOngRequest dto,
                                                          @PathVariable("id") Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Apagar endereço",
        description = "Apaga um endereço de uma ONG pelo id."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Endereço apagado com sucesso!"),
        @ApiResponse(responseCode = "404", description = "Endereço da ONG não encontrado!")
    })
    public ResponseEntity<Void> excluirEnderecoPorId(@PathVariable("id") Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }
}
