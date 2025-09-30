package br.com.fuctura.gestaoalugueis.controller;

import br.com.fuctura.gestaoalugueis.controller.interfaces.AluguelController;
import br.com.fuctura.gestaoalugueis.dto.AluguelAtrasadoDTO;
import br.com.fuctura.gestaoalugueis.dto.AluguelDTO;
import br.com.fuctura.gestaoalugueis.service.AluguelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alugueis")
public class AluguelControllerImpl implements AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @Operation(description = "Registra um novo aluguel no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluguel registrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida. Verifique os dados fornecidos."),
            @ApiResponse(responseCode = "404", description = "Imóvel ou inquilino não encontrado.")
    })
    @PostMapping
    public ResponseEntity<AluguelDTO> save(@Valid @RequestBody AluguelDTO aluguelDTO) {
        AluguelDTO aluguelSalvo = aluguelService.criarAluguel(aluguelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluguelSalvo);
    }

    @Operation(description = "Lista todos os aluguéis que estão atrasados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de aluguéis atrasados retornada com sucesso.")
    })
    @GetMapping("/atrasados")
    public ResponseEntity<List<AluguelAtrasadoDTO>> listarAlugueisAtrasados() {
        List<AluguelAtrasadoDTO> alugueisAtrasados = aluguelService.listarAlugueisAtrasados();
        return ResponseEntity.ok(alugueisAtrasados);
    }

    @Operation(description = "Marca um aluguel como pago.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluguel marcado como pago com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluguel não encontrado."),
            @ApiResponse(responseCode = "400", description = "ID do aluguel inválido.")
    })
    @PutMapping("/{id}/marcar-pago")
    public ResponseEntity<String> marcarComoPago(@PathVariable Long id) {
        AluguelDTO aluguelAtualizado = aluguelService.marcarComoPago(id);
        return ResponseEntity.ok("Aluguel ID " + aluguelAtualizado.getId() + " marcado como pago com sucesso!");
    }
}