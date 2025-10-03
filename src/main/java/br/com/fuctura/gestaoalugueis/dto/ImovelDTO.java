package br.com.fuctura.gestaoalugueis.dto;

import br.com.fuctura.gestaoalugueis.validation.NotBlankButNullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ImovelDTO {

    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotBlankButNullable
    private String endereco;

}
