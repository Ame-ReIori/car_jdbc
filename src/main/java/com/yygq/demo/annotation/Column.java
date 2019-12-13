package com.yygq.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * column annotation
 * @author ame
 * @describe: this annotation is column's annotation
 *            it returns column's name(attributes)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Column {
    /**
     * @return column's name
     */
    String name();
}
