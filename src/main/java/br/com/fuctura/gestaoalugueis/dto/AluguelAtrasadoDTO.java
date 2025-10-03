package br.com.fuctura.gestaoalugueis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO para representar aluguéis em atraso na listagem.
 * Contém apenas as informações necessárias para exibição.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AluguelAtrasadoDTO {

    private Long id;
    private String inquilino;
    private String imovel;
    private BigDecimal valor;
    private Integer diasEmAtraso;

}