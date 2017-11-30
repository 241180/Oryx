package com.oryx.core.annotation.decl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ask for automatic generation of a builder for a constructor
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface GenServiceDelegate {
    String extendType() default "com.oryx.core.service.AbstractCrudServiceMethods";
}
