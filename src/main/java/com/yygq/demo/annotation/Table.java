package com.yygq.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * table annotation
 * @author ame
 * @description: this annotation is table's annotation
 *               it returns table's name
 */
@Retention(RetentionPolicy.RUNTIME) //where annotation maintains
@Target({ElementType.TYPE})
public @interface Table {
    /**
     * @return table's name
     */
    String name();
}
