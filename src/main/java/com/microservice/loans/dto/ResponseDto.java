package com.microservice.loans.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@Schema(
        name = "Response",
        description = "Schema para apresentar informações de resposta bem-sucedidas"
)
@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status code da respostas"
    )
    private String statusCode;

    @Schema(
            description = "Mensagem de status que estará presente na resposta"
    )
    private String statusMsg;
}
