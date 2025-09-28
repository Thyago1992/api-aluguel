package br.com.fuctura.gestaoalugueis.repository;

import br.com.fuctura.gestaoalugueis.model.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {
}
