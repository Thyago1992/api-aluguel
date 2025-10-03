package br.com.fuctura.gestaoalugueis.exception;

/**
 * Exceção lançada quando uma regra de negócio é violada.
 * Exemplo: tentar alugar um imóvel que já possui aluguel ativo.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}