package com.malsum.thymeleafdemo.CustomAnnotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RoleConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD,})//you can apply this annotation to Methods or Fields
@Retention(RetentionPolicy.RUNTIME)//use this annotation at runtime
public @interface BasicRole {
    //define default role name
    public String value() default "ROLE_EMPLOYEE";
    //define default error message
    public String message() default "Must start with Role";
    //define default groups
    public Class<?> [] groups() default {};
    //define default payloads
    //payloads provide custom details about validation failure like, severity level or error code
    public Class<? extends Payload>[] payload() default{};
}
