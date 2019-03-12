package com.javabootcamp.main;

import com.javabootcamp.main.objects.Car;
import com.javabootcamp.main.objects.TVshow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class Lesson07Controller
{
    @GetMapping("/07")
    public String lesson07(Model model)
    {
        model.addAttribute("car", new Car());
        return("lesson07");
    }
    @PostMapping("/07")
    public String lesson07confirm(@Valid @ModelAttribute("car") Car car, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("car",car);
            return "lesson07";
        }
        model.addAttribute("car",car);
        return "lesson07confirm";
    }
}
