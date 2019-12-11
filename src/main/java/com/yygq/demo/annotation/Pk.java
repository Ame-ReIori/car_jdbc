package com.yygq.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * primary key annotation
 * @author ame
 * @description: this annotation is primary key's annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Pk {
    /**
     * @return auto increase pk
     */
    boolean auto() default true;
}
