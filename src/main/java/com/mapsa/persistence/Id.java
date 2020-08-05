package com.mapsa.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Esmaeil Sadeghi, 8/5/20 4:25 PM
 */
@Retention(RUNTIME)
@Target({FIELD,METHOD})
public @interface Id {
}
