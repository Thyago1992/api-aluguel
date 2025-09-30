package br.com.fuctura.gestaoalugueis.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ImovelDTO {

    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;
    private String endereco;

}
