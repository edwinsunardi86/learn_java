package sos.group.integrated.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoDigitsValidator implements ConstraintValidator<NoDigits, String>{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext){
        if(value == null) return true; // gunakan @NotEmpty untuk null check
        return !value.matches(".*\\d.*"); // false jika mengandung angka
    }
}
