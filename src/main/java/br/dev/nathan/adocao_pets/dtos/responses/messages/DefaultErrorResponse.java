package br.dev.nathan.adocao_pets.dtos.responses.messages;

import java.time.LocalDateTime;

public record DefaultErrorResponse(
    int status,
    String erro,
    String mensagem,
    LocalDateTime horario
) {}