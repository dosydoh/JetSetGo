package com.example.capstone.repository;

//public interface FieldMatch {

import jakarta.validation.Payload;
import jakarta.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {

        String first ();

        String second ();

        String message ()
        default
            "Fields do not match";

            Class<?>[] groups ()
        default {
        }
        ;

        Class<? extends Payload>[] payload ()
        default {
        }
        ;
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        @Documented
        @interface List {
            FieldMatch[] value();
        }
    }
