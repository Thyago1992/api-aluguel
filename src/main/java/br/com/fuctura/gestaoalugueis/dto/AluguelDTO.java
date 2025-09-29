package br.com.fuctura.gestaoalugueis.dto;

import br.com.fuctura.gestaoalugueis.model.Imovel;
import br.com.fuctura.gestaoalugueis.model.Inquilino;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AluguelDTO {

    private Long id;
    private Imovel imovel;
    private Inquilino inquilino;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private Boolean pago;
    private Integer diasEmAtraso;

    public AluguelDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Integer getDiasEmAtraso() {
        return diasEmAtraso;
    }

    public void setDiasEmAtraso(Integer diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }
}
