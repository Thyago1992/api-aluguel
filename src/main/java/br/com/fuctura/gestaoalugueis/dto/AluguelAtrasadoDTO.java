package br.com.fuctura.gestaoalugueis.dto;

import java.math.BigDecimal;

public class AluguelAtrasadoDTO {

    private Long id;
    private String inquilino; // Nome do Inquilino
    private String imovel;    // Descrição do Imóvel
    private BigDecimal valor;
    private Integer diasEmAtraso;

    // Construtor, Getters e Setters (omitidos para brevidade)

    // Construtor completo para facilitar o mapeamento no Service
    public AluguelAtrasadoDTO(Long id, String inquilino, String imovel, BigDecimal valor, Integer diasEmAtraso) {
        this.id = id;
        this.inquilino = inquilino;
        this.imovel = imovel;
        this.valor = valor;
        this.diasEmAtraso = diasEmAtraso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInquilino() {
        return inquilino;
    }

    public void setInquilino(String inquilino) {
        this.inquilino = inquilino;
    }

    public String getImovel() {
        return imovel;
    }

    public void setImovel(String imovel) {
        this.imovel = imovel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getDiasEmAtraso() {
        return diasEmAtraso;
    }

    public void setDiasEmAtraso(Integer diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }
}