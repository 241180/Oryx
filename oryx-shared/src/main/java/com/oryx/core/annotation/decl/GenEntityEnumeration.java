package com.oryx.core.annotation.decl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ask for automatic generation of a Enumeration for an entity
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface GenEntityEnumeration {
}
