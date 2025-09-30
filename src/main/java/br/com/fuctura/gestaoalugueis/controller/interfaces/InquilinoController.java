package br.com.fuctura.gestaoalugueis.controller.interfaces;

import br.com.fuctura.gestaoalugueis.dto.InquilinoDTO;
import org.springframework.http.ResponseEntity;

public interface InquilinoController {

    ResponseEntity<InquilinoDTO> save(InquilinoDTO inquilinoDTO);
}
