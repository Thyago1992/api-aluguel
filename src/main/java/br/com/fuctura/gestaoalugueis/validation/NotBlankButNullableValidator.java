package br.com.fuctura.gestaoalugueis.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankButNullableValidator
        implements ConstraintValidator<NotBlankButNullable, String> {

    @Override
    public void initialize(NotBlankButNullable constraintAnnotation) {
        // Inicialização, se necessário (geralmente vazio)
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Se for null, permite (retorna true = válido)
        if (value == null) {
            return true;
        }

        // Se não for null, verifica se não é vazio ou só espaços
        // trim() remove espaços e isEmpty() verifica se ficou vazio
        return !value.trim().isEmpty();
    }
}
