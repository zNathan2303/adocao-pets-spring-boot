package br.dev.nathan.adocao_pets.exceptions;

import br.dev.nathan.adocao_pets.dtos.errors.DefaultErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
    * ERROS 404 - ENTIDADES NÃO ENCONTRADAS
    * */

    @ExceptionHandler(EnderecoAdotanteNaoEncontradoException.class)
    private ResponseEntity<DefaultErrorResponse> tratarEnderecoAdotanteNaoEncontrado() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "Endereço do adotante não encontrado!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(EnderecoOngNaoEncontradoException.class)
    private ResponseEntity<DefaultErrorResponse> tratarEnderecoOngNaoEncontrado() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "Endereço da ONG não encontrado!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(RacaNaoEncontradaException.class)
    private ResponseEntity<DefaultErrorResponse> tratarRacaNaoEncontrada() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "Raça não encontrada!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(AdotanteNaoEncontradoException.class)
    private ResponseEntity<DefaultErrorResponse> tratarAdotanteNaoEncontrado() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "Adotante não encontrado!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(OngNaoEncontradaException.class)
    private ResponseEntity<DefaultErrorResponse> tratarOngNaoEncontrada() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "ONG não encontrada!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(EspecieNaoEncontradaException.class)
    private ResponseEntity<DefaultErrorResponse> tratarEspecieNaoEncontrada() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "Espécie não encontrada!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    /*
    * ERROS 400 - ERROS RELACIONADOS A REQUISIÇÃO MAL FORMULADO
    * */

    @ExceptionHandler(AdotanteInexistenteException.class)
    private ResponseEntity<DefaultErrorResponse> tratarAdotanteInexistente() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            400,
            "Bad Request",
            "Adotante informado não existe!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(OngInexistenteException.class)
    private ResponseEntity<DefaultErrorResponse> tratarOngInexistente() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            400,
            "Bad Request",
            "ONG informada não existe!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(EspecieInexistenteException.class)
    private ResponseEntity<DefaultErrorResponse> tratarEspecieInexistente() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            400,
            "Bad Request",
            "Espécie informada não existe!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<DefaultErrorResponse> tratarErrosDeValidacao(MethodArgumentNotValidException exception) {

        String errorMessages = exception.getBindingResult()
            .getAllErrors()
            .stream()
            .map(x -> x.getDefaultMessage())
            .collect(Collectors.joining(" "));

        DefaultErrorResponse error = new DefaultErrorResponse(
            400,
            "Bad Request",
            errorMessages,
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(DateTimeParseException.class)
    private ResponseEntity<DefaultErrorResponse> tratarErrosDeData(DateTimeParseException exception) {
        DefaultErrorResponse error = new DefaultErrorResponse(
            400,
            "Bad Request",
            "Data inexistente ou formato inválido: " + exception.getParsedString(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<DefaultErrorResponse> tratarErroDoCorpoDaRequisicao() {
        DefaultErrorResponse error = new DefaultErrorResponse(
            400,
            "Bad Request",
            "O corpo da requisição está mal formulado!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(error);
    }
}
