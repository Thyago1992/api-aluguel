package br.com.fuctura.gestaoalugueis.exception;

/**
 * Exceção lançada quando há tentativa de criar um recurso que já existe no sistema.
 * Exemplo: cadastrar inquilino com email duplicado.
 */
public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String message) {
        super(message);
    }
}