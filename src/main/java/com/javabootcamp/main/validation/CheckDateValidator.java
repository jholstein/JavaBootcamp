package com.javabootcamp.main.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CheckDateValidator implements ConstraintValidator<CheckDateInFuture, String> {

    private String pattern;
    private Calendar calendar;

    @Override
    public void initialize(CheckDateInFuture constraintAnnotation) {
        calendar = Calendar.getInstance();
        calendar.setLenient(false);
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if ( object == null ) {
            return false;
        }

        try {
            //Date date = new SimpleDateFormat(pattern).parse(object);
            //if (calendar.getTime() <=
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}