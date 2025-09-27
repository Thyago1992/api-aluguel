package br.com.fuctura.gestaoalugueis.repository;

import model.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {
}
