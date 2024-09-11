package com.microservice.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "Loans",
        description = "Esquema para armazenar informações do Empréstimo"
)
@Data
public class LoansDto {

    @NotEmpty(message = "O número de celular não pode ser nulo ou vazio")
    @Pattern(regexp="(^$|[0-9]{10})", message = "O número de celular deve ter 10 dígitos")
    @Schema(
            description = "Número de celular do cliente", example = "4365327698"
    )
    private String mobileNumber;

    @NotEmpty(message = "O número do empréstimo não pode ser nulo ou vazio")
    @Pattern(regexp="(^$|[0-9]{12})", message = "O número do empréstimo deve ter 12 dígitos")
    @Schema(
            description = "Número do empréstimo do cliente", example = "548732457654"
    )
    private String loanNumber;

    @NotEmpty(message = "O tipo de empréstimo não pode ser nulo ou vazio")
    @Schema(
            description = "Tipo do empréstimo", example = "Empréstimo Imobiliário"
    )
    private String loanType;

    @Positive(message = "O valor total do empréstimo deve ser maior que zero")
    @Schema(
            description = "Valor total do empréstimo", example = "100000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "O valor total pago deve ser igual ou maior que zero")
    @Schema(
            description = "Valor total pago do empréstimo", example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "O valor total em aberto deve ser igual ou maior que zero")
    @Schema(
            description = "Valor total em aberto do empréstimo", example = "99000"
    )
    private int outstandingAmount;

}
