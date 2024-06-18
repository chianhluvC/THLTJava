package com.thlaptrinhjava.Lab03.Validator;

import com.thlaptrinhjava.Lab03.Validator.annotation.ValidUserId;
import com.thlaptrinhjava.Lab03.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if(user==null)
            return true;
        return user.getId() != null;
    }

}
