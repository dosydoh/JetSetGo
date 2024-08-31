package com.example.capstone.repository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import org.apache.commons.beanutils.BeanUtils;


public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstFieldName = constraintAnnotation.first();
        this.secondFieldName = constraintAnnotation.second();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, ConstraintValidatorContext context) {
        try {
            //final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            //final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
            //return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
            final Object firstValue = getFieldValue(value, firstFieldName);
            final Object secondValue = getFieldValue(value, secondFieldName);

            return firstValue != null && firstValue.equals(secondValue);
        } catch (final Exception ignore) {
        }
        return false;
    }

    private Object getFieldValue(Object value, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        final Field field = value.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(value);
    }
}

