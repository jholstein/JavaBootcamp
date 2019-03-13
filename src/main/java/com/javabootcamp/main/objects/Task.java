package com.javabootcamp.main.objects;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@Entity
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String dueDateString;


    private LocalDate dueDate;



    @Min(1)
    @Max(5)
    private int priority;

    public Task() { }

    public Task(String name,String dueDateString,int priority)
    {
        this.name = name;
        this.dueDateString = dueDateString;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDateString() {
        return dueDateString;
    }

    public void setDueDateString(String dueDateString) {
        this.dueDateString = dueDateString;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {


        return  LocalDate.parse(this.getDueDateString(), DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;

    }
}
