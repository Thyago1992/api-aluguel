package br.com.fuctura.gestaoalugueis.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * Anotação de validação customizada que permite valores null,
 * mas rejeita strings vazias ou contendo apenas espaços em branco.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankButNullableValidator.class)
@Documented
public @interface NotBlankButNullable {
    String message() default "Campo não pode ser vazio ou conter apenas espaços";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}