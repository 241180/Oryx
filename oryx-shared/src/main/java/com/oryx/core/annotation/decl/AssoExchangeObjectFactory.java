package com.oryx.core.annotation.decl;

import com.oryx.core.factory.IFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ask for automatic generation of a builder for a constructor
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AssoExchangeObjectFactory {
    Class<? extends IFactory> classType();
}
