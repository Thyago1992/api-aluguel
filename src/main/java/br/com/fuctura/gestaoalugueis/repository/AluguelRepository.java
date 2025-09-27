package br.com.fuctura.gestaoalugueis.repository;

import model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findByDataVencimentoBeforeAndPagoFalse(LocalDate data);
}

