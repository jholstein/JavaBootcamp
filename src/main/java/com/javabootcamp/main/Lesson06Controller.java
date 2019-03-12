package com.javabootcamp.main;

import com.javabootcamp.main.objects.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.javabootcamp.main.objects.Song;

@Controller
public class Lesson06Controller
{
    @GetMapping("/06")
    public String lesson06Get(Model model)
    {
        model.addAttribute("employee",new Employee());
        return("lesson06");
    }
    @PostMapping("/06")
    public String lesson06Post(@ModelAttribute Employee employee, Model model)
    {
        model.addAttribute("employee",employee);
        return("lesson06confirm");
    }


}
