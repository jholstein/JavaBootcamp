package com.javabootcamp.main;

import com.javabootcamp.main.objects.Dog;
import com.javabootcamp.main.objects.Task;
import com.javabootcamp.main.repos.DogRepository;
import com.javabootcamp.main.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Lesson09Controller
{

    @Autowired
    TaskRepository taskRepository;


    @GetMapping("/09")
    public String lesson09(Model model)
    {
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskRepository.findAll());
        return("lesson09");
    }
    @PostMapping("/09")
    public String lesson09confirm(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("tasks",taskRepository.findAll());
            return "lesson09";
        }


        taskRepository.save(task);



        model.addAttribute("task",task);
        model.addAttribute("tasks",taskRepository.findAll());


        //dogRepository.findAll().forEach(dogs::add);
        return "lesson09";
    }
}
