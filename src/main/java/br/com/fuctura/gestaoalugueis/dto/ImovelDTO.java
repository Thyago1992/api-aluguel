package br.com.fuctura.gestaoalugueis.dto;

import br.com.fuctura.gestaoalugueis.validation.NotBlankButNullable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImovelDTO {

    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotBlankButNullable
    private String endereco;

}
