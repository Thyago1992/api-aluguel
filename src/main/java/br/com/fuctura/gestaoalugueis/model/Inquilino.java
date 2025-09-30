package br.com.fuctura.gestaoalugueis.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inquilinos")
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String email;

}