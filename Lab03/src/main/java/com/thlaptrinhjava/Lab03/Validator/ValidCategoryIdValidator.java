package com.thlaptrinhjava.Lab03.Validator;

import com.thlaptrinhjava.Lab03.Validator.annotation.ValidCategoryId;
import com.thlaptrinhjava.Lab03.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {


    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext) {
        return category != null && category.getId() != null;
    }
}
