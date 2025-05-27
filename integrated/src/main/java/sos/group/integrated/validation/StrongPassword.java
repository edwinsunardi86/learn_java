package sos.group.integrated.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = StrongPasswordValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface StrongPassword {
    String message() default "Password harus mengandung minimal 1 huruf besar, 1 angka, dan 1 simbol";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}
