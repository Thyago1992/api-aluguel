package br.com.fuctura.gestaoalugueis.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String error;
    private String message;
    private String path;
    private List<FieldError> errors;

    // Construtor personalizado para erros simples (sem lista de erros)
    public ErrorResponse(int status, String error, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Inner class para erros de validação
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FieldError {
        private String field;
        private String message;
    }
}