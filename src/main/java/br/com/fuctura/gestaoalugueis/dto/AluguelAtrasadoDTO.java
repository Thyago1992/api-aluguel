package br.com.fuctura.gestaoalugueis.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AluguelAtrasadoDTO {

    private Long id;
    private String inquilino; // Nome do Inquilino
    private String imovel;    // Descrição do Imóvel
    private BigDecimal valor;
    private Integer diasEmAtraso;

    // Construtor completo para facilitar o mapeamento no Service
    public AluguelAtrasadoDTO(Long id, String inquilino, String imovel, BigDecimal valor, Integer diasEmAtraso) {
        this.id = id;
        this.inquilino = inquilino;
        this.imovel = imovel;
        this.valor = valor;
        this.diasEmAtraso = diasEmAtraso;
    }

}