package com.javabootcamp.main.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CheckDateValidator implements ConstraintValidator<CheckDateInFuture, String> {

    //private String pattern;
    //private Calendar calendar;


    @Override
    public void initialize(CheckDateInFuture constraintAnnotation) {
        //calendar = Calendar.getInstance();
        //calendar.setLenient(false);
        //this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String dueDateString, ConstraintValidatorContext constraintContext) {
        if ( dueDateString == null || dueDateString == "" ) {
            return false;
        }

        try {
            //Date date = new SimpleDateFormat(pattern).parse(object);
            LocalDate taskDate = LocalDate.parse(dueDateString, DateTimeFormatter.ISO_LOCAL_DATE);
            if (LocalDate.now().compareTo(taskDate) < 0){return true;}
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}