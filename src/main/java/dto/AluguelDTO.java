package dto;

import model.Aluguel;
import model.Imovel;
import model.Inquilino;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

public class AluguelDTO {

    private Long id;
    private Imovel imovel;
    private Inquilino inquilino;
    private Double valor;
    private LocalDate dataVencimento;
    private Boolean pago;

    public AluguelDTO(Aluguel aluguel) {
        BeanUtils.copyProperties(aluguel, this);
    }

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
