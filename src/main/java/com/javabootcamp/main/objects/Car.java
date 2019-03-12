package com.javabootcamp.main.objects;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car
{


    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private long id;

    @NotNull
    @Size(min=1,max=15)
    private String name;

    @NotNull
    @Size(min=1,max=15)
    private String type;


    @Size(min=0,max=50)
    private String description;

    @NotNull
    private int year;

    @NotNull
    @Size(min=1,max=15)
    private String make;


    @NotNull
    @Size(min=1,max=15)
    private String model;

    public Car() {
    }

    public Car(@NotNull @Size(min = 1, max = 15) String name, @NotNull @Size(min = 1, max = 15) String type, @Size(min = 0, max = 50) String description, @NotNull @Size(min = 1, max = 15) int year, @NotNull @Size(min = 1, max = 15) String make, @NotNull @Size(min = 1, max = 15) String model) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
