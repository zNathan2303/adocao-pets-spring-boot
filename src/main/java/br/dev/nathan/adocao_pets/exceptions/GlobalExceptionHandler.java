package br.dev.nathan.adocao_pets.exceptions;

import br.dev.nathan.adocao_pets.dtos.errors.DefaultErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EspecieNaoEncontradaException.class)
    private ResponseEntity<DefaultErrorResponse> especieNaoEncontradaHandler(EspecieNaoEncontradaException exception) {

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
}
