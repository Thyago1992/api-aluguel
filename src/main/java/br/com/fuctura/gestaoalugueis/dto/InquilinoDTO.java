package br.com.fuctura.gestaoalugueis.dto;

import br.com.fuctura.gestaoalugueis.validation.NotBlankButNullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InquilinoDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlankButNullable
    @Email(message = "Email deve ser válido")
    private String email;

}
