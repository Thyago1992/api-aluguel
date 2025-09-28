package br.com.fuctura.gestaoalugueis.controller;

import br.com.fuctura.gestaoalugueis.controller.interfaces.ImovelController;
import br.com.fuctura.gestaoalugueis.dto.ImovelDTO;
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
import br.com.fuctura.gestaoalugueis.service.ImovelService;

@RestController
@RequestMapping(value = "/imoveis")
public class ImovelControllerImpl implements ImovelController {

    @Autowired
    private ImovelService imovelService;

    @Operation(description = "Cadastra um novo imóvel no sistema.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Imóvel cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida. Verifique os dados fornecidos.")})
    @PostMapping
    public ResponseEntity<ImovelDTO> save(@Valid @RequestBody ImovelDTO imovelDTO) {
        ImovelDTO imovelSalvo = imovelService.cadastrarImovel(imovelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(imovelSalvo);
    }
}
