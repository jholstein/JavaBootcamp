package com.javabootcamp.main.dataloaders;

import com.javabootcamp.main.objects.Car;
import com.javabootcamp.main.objects.Task;
import com.javabootcamp.main.repos.CarRepository;
import com.javabootcamp.main.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... strings) throws Exception
    {

        Car car = new Car("Herby", "Coup", "A tiny car with alot of spirit", 1993, "Mini Cooper", "The Extra Mini");
        carRepository.save(car);

        car = new Car("Mine", "Sedan", "A green machine", 1996, "Honda", "Accord");
        carRepository.save(car);

        car = new Car("Highlander", "SUV", "A mammoth of a car", 2005, "Toyota", "Highlander");
        carRepository.save(car);
    }
}
