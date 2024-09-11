package com.microservice.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema para armazenar informações de resposta a erros"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path chamado pelo  client"
    )
    private String apiPath;

    @Schema(
            description = "Código para representar qual erro aconteceu"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Mensagem de erro representando o que aconteceu"
    )
    private String errorMessage;

    @Schema(
            description = "Representação de quando houve o erro"
    )
    private LocalDateTime errorTime;

}
