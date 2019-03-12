package com.javabootcamp.main;

import com.javabootcamp.main.objects.Car;
import com.javabootcamp.main.objects.Task;
import com.javabootcamp.main.repos.CarRepository;
import com.javabootcamp.main.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Lesson11Controller
{

    @Autowired
    CarRepository carRepository;


    @GetMapping("/11")
    public String lesson11(Model model)
    {
        model.addAttribute("car", new Car());
        model.addAttribute("cars", carRepository.findAll());
        return("lesson11");
    }
    @PostMapping("/11")
    public String lesson11confirm(@Valid @ModelAttribute("car") Car car, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("cars",carRepository.findAll());
            return "lesson11";
        }


        carRepository.save(car);



        model.addAttribute("car",car);
        model.addAttribute("cars",carRepository.findAll());


        //dogRepository.findAll().forEach(dogs::add);
        return "lesson11";
    }
}



