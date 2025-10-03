package br.com.fuctura.gestaoalugueis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alugueis")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imovel_id", nullable = false)
    private Imovel imovel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquilino_id")
    private Inquilino inquilino;


    @Column(nullable = false)
    private BigDecimal valor;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(nullable = false)
    private Boolean pago = false;

}
