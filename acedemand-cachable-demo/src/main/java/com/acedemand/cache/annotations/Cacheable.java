package com.acedemand.cache.annotations;

import java.lang.annotation.*;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 6/18/2015.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Cacheable {
    String value() default "";
}
