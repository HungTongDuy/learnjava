package com.example.demo.Validator;

import javax.validation.ConstraintValidatorContext;

public class ConstraintValidatorUtils {

    private ConstraintValidatorUtils() { }

    public static void createConstraintViolation(ConstraintValidatorContext context, String errorCode) {
        // Disable nhung tham so constraint violation mac dinh
        context.disableDefaultConstraintViolation();

        // Them nhung tham so constraint violation duoc truyen vao thong qua method nay
        addConstraintViolation(context, errorCode);
    }

    public static void addConstraintViolation(ConstraintValidatorContext context, String errorCode) {
        ConstraintValidatorContext.ConstraintViolationBuilder builder = context.buildConstraintViolationWithTemplate(errorCode);
        builder.addConstraintViolation();
    }
}
