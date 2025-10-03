package br.com.fuctura.gestaoalugueis.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankButNullableValidator.class)
@Documented
public @interface NotBlankButNullable {
    String message() default "Campo não pode ser vazio ou conter apenas espaços";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}