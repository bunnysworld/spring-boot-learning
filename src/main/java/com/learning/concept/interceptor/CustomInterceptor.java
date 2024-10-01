package com.learning.concept.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomInterceptor {

    String key() default "defaultKey";

    int intKey() default 0;

    Class<?> classType() default String.class;

    String[] arrKey() default {"key_1", "key_2"};

    int[] arrIntKey() default {1, 2};

}
