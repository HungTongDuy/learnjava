package com.example.demo.Validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookCodeValidator implements ConstraintValidator<BookCodeVerify, String> {

    private static final String BOOK_CODE_PREFIX = "BK_";

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {

        if(!StringUtils.hasText(code)) {
            ConstraintValidatorUtils.createConstraintViolation(context, "Please enter book code.");
            return false;
        }

        if (!code.startsWith(BOOK_CODE_PREFIX)) {
            ConstraintValidatorUtils.createConstraintViolation(context,"Book code must be start with BK_");
            return false;
        }

        return true;
    }
}
