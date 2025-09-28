package br.com.fuctura.gestaoalugueis.controller;

import br.com.fuctura.gestaoalugueis.controller.interfaces.InquilinoController;
import br.com.fuctura.gestaoalugueis.dto.InquilinoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fuctura.gestaoalugueis.service.InquilinoService;

@RestController
@RequestMapping(value = "/inquilinos")
public class InquilinoControllerImpl implements InquilinoController {

    @Autowired
    private InquilinoService inquilinoService;

    @Operation(description = "Cadastra um novo inquilino no sistema.")

    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Inquilino cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida. Verifique os dados fornecidos.")})
    @PostMapping
    public ResponseEntity<InquilinoDTO> save(@Valid @RequestBody InquilinoDTO inquilinoDTO) {
        InquilinoDTO inquilinoSalvo = inquilinoService.cadastrarInquilino(inquilinoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(inquilinoSalvo);
    }

}
