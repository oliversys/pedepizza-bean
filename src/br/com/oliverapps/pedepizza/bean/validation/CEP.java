package br.com.oliverapps.pedepizza.bean.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CEP
{
  String message() default "CEP inválido";
  
  Class<?>[] groups() default {};
}