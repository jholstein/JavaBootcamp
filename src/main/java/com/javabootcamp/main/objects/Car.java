package com.javabootcamp.main.objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car
{
    @NotNull
    @Size(min=1,max=15)
    private String name;

    @NotNull
    @Size(min=1,max=15)
    private String type;


    @Size(min=0,max=50)
    private String description;

    public Car() {
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
}
