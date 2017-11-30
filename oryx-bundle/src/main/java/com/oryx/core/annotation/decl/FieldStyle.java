package com.oryx.core.annotation.decl;

import com.oryx.core.bundle.IBundle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies that this constructor parameter is mandatory
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface FieldStyle {
    boolean mandatory() default false;

    boolean readOnly() default false;

    int textLength() default IBundle.MAX_TEXT_LENGTH;
}
