package br.com.fuctura.gestaoalugueis.exception;

/**
 * Exceção lançada quando um recurso solicitado não é encontrado no sistema.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceName, Long id) {
        super(String.format("%s com ID %d não encontrado", resourceName, id));
    }
}