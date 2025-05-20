package sos.group.integrated.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import sos.group.integrated.model.UserForm;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserForm>{

    @Override
    public boolean isValid(UserForm form, ConstraintValidatorContext context){
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Password dan konfirmasi harus sama").addConstraintViolation();
        return !(form.getPassword() == null || form.getConfirmPassword() == null || !form.getPassword().equals(form.getConfirmPassword()));
    }
}
