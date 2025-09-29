package br.com.fuctura.gestaoalugueis.repository;

import br.com.fuctura.gestaoalugueis.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findByPagoFalseAndInquilinoIsNotNullAndDataVencimentoIsNotNullAndDataVencimentoBefore(LocalDate data);

    //@Query("SELECT a FROM Aluguel a WHERE a.pago = false AND a.inquilino IS NOT NULL AND a.dataVencimento IS NOT NULL AND a.dataVencimento < :data")
    //List<Aluguel> findAtrasados(@Param("data") LocalDate data);
}

