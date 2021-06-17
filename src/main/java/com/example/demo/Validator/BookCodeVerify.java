package com.example.demo.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BookCodeValidator.class)
public @interface BookCodeVerify {

    String message() default "Invalid book code.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
