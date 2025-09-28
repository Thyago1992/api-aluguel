package br.com.fuctura.gestaoalugueis.repository;

import br.com.fuctura.gestaoalugueis.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
