package br.com.fuctura.gestaoalugueis.dto;

import br.com.fuctura.gestaoalugueis.model.Imovel;
import br.com.fuctura.gestaoalugueis.model.Inquilino;
import br.com.fuctura.gestaoalugueis.validation.NotBlankButNullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AluguelDTO {

    private Long id;

    @NotNull(message = "Imóvel é obrigatório")
    private Imovel imovel;

    @NotBlankButNullable
    private Inquilino inquilino;

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.0", message = "Valor deve ser maior ou igual a zero")
    private BigDecimal valor;

    @NotBlankButNullable
    private LocalDate dataVencimento;

    @NotBlankButNullable
    private Boolean pago;

    @NotBlankButNullable
    private Integer diasEmAtraso;

}
