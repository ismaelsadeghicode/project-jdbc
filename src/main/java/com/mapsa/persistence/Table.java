package com.mapsa.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Esmaeil Sadeghi, 8/5/20 2:49 PM
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Table {

    String name() default "";
    String schema() default "";
}
