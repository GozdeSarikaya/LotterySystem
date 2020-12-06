package com.mkyong.validator;

import com.mkyong.entity.Player;
import com.mkyong.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PlayerValidator implements Validator {

    @Autowired
    private PlayerService playerService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Player.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        String firstName = (String) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (firstName.length() < 6 || firstName.length() > 32) {
            errors.rejectValue("firstName", "Size.userForm.firstName");
        }

/*        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (user.getLastName().length() < 6 || user.getLastName().length() > 32) {
            errors.rejectValue("lastName", "Size.userForm.lastName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (!user.getEmail().contains("@")) {
            errors.rejectValue("email", "Size.userForm.email");
        }*/
    }
}