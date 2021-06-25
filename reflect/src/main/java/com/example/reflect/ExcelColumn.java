package com.example.reflect;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {

    int index();

    String title();

    String description() default "Default value";

}
