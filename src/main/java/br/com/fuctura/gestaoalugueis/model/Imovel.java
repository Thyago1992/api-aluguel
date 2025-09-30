package br.com.fuctura.gestaoalugueis.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "imoveis")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column
    private String endereco;

}