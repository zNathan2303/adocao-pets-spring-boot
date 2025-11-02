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

    @ExceptionHandler(RacaNaoEncontradaException.class)
    private ResponseEntity<DefaultErrorResponse> racaNaoEncontradaHandler() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "Raça não encontrada!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(EspecieNaoExistenteException.class)
    private ResponseEntity<DefaultErrorResponse> especieNaoExistenteHandler() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            400,
            "Bad Request",
            "Espécie informada não existe!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(AdotanteNaoEncontradoException.class)
    private ResponseEntity<DefaultErrorResponse> adotanteNaoEncontradaHandler() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "Adotante não encontrado!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(OngNaoEncontradaException.class)
    private ResponseEntity<DefaultErrorResponse> ongNaoEncontradaHandler() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "ONG não encontrada!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(EspecieNaoEncontradaException.class)
    private ResponseEntity<DefaultErrorResponse> especieNaoEncontradaHandler() {

        DefaultErrorResponse error = new DefaultErrorResponse(
            404,
            "Not Found",
            "Espécie não encontrada!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<DefaultErrorResponse> validationHandler(MethodArgumentNotValidException exception) {

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
    private ResponseEntity<DefaultErrorResponse> dateTimeParseHandler(DateTimeParseException exception) {
        DefaultErrorResponse error = new DefaultErrorResponse(
            400,
            "Bad Request",
            "Data inexistente ou formato inválido: " + exception.getParsedString(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<DefaultErrorResponse> errorInRequestBody() {
        DefaultErrorResponse error = new DefaultErrorResponse(
            400,
            "Bad Request",
            "O corpo da requisição está mal formulado!",
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(error);
    }
}
