package br.com.fuctura.gestaoalugueis.controller;

import br.com.fuctura.gestaoalugueis.controller.interfaces.AluguelController;
import br.com.fuctura.gestaoalugueis.dto.AluguelDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fuctura.gestaoalugueis.service.AluguelService;

import java.util.List;

@RestController
@RequestMapping(value = "/alugueis")
public class AluguelControllerImpl implements AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @Operation(description = "Registra um novo aluguel no sistema.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Aluguel registrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida. Verifique os dados fornecidos.")})
    @PostMapping
    public ResponseEntity<AluguelDTO> save(@Valid @RequestBody AluguelDTO aluguelDTO) {
        AluguelDTO aluguelSalvo = aluguelService.criarAluguel(aluguelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluguelSalvo);
    }

    @GetMapping
    public ResponseEntity<List<AluguelDTO>> listarAlugueisAtrasados() {
        List<AluguelDTO> alugueisAtrasados = aluguelService.listarAlugueisAtrasados();
        return ResponseEntity.ok().body(alugueisAtrasados);
    }

    @PutMapping("/{id}/marcar-pago")
    public ResponseEntity<String> marcarComoPago(@PathVariable Long id) {
        boolean sucesso = aluguelService.marcarComoPago(id);

        if (sucesso) {
            return ResponseEntity.ok("Aluguel pago com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
