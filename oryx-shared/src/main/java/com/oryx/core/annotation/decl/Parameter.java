package com.oryx.core.annotation.decl;

public @interface Parameter {
    boolean mandatory() default false;

    String name() default "";
}
