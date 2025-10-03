package br.com.fuctura.gestaoalugueis.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankButNullableValidator
        implements ConstraintValidator<NotBlankButNullable, String> {

    @Override
    public void initialize(NotBlankButNullable constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return !value.trim().isEmpty();
    }
}