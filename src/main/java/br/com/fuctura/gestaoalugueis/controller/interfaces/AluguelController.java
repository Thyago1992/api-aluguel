package br.com.fuctura.gestaoalugueis.controller.interfaces;

import br.com.fuctura.gestaoalugueis.dto.AluguelAtrasadoDTO;
import br.com.fuctura.gestaoalugueis.dto.AluguelDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AluguelController {

    ResponseEntity<AluguelDTO> save(AluguelDTO aluguelDTO);

    ResponseEntity<String> marcarComoPago(Long id);

    ResponseEntity<List<AluguelAtrasadoDTO>> listarAlugueisAtrasados();
}
