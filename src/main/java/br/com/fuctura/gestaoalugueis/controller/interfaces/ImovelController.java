package br.com.fuctura.gestaoalugueis.controller.interfaces;

import br.com.fuctura.gestaoalugueis.dto.ImovelDTO;
import org.springframework.http.ResponseEntity;

public interface ImovelController {

    ResponseEntity<ImovelDTO> save(ImovelDTO imovelDTO);
}
