package com.mapsa.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Esmaeil Sadeghi, 8/5/20 4:13 PM
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface Entity {
}
