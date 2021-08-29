package com.malsum.thymeleafdemo.CustomAnnotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoleConstraintValidator implements ConstraintValidator<BasicRole, String> {

    //define role we can validate against
    private String role;
    private Set<String> roleSet = Stream.of("ROLE_EMPLOYEE","ROLE_MANAGER","ROLE_ADMIN")
            .collect(Collectors.toCollection(HashSet::new));


    @Override
    public void initialize(BasicRole basicRole) {
        role = basicRole.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {//first argument is the html form data given by user, second is used to give additional
        //error messages if needed
        //validation logic, check if role is one of three possible options

        boolean validation = roleSet.contains(role);
        return validation;
    }
}
