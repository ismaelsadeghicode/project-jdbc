package com.mapsa.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Esmaeil Sadeghi, 8/5/20 2:52 PM
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Column {

    String name() default "";

    String dataType();

    boolean unique() default false;

    boolean nullable() default true;

    int length() default 255;
}
