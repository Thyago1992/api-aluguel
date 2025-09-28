package br.com.fuctura.gestaoalugueis.dto;

import br.com.fuctura.gestaoalugueis.model.Imovel;
import br.com.fuctura.gestaoalugueis.model.Inquilino;

import java.time.LocalDate;

public class AluguelDTO {

    private Long id;
    private Imovel imovel;
    private Inquilino inquilino;
    private Double valor;
    private LocalDate dataVencimento;
    private Boolean pago;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
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
}
