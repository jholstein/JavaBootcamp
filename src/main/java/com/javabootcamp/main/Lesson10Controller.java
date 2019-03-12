package com.javabootcamp.main;

import com.javabootcamp.main.objects.Task;
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
public class Lesson10Controller
{

    @Autowired
    TaskRepository taskRepository;


    @GetMapping("/10")
    public String lesson10(Model model)
    {
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskRepository.findAll());
        return("lesson10");
    }
    @PostMapping("/10")
    public String lesson10confirm(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("tasks",taskRepository.findAll());
            return "lesson10";
        }


        taskRepository.save(task);



        model.addAttribute("task",task);
        model.addAttribute("tasks",taskRepository.findAll());


        //dogRepository.findAll().forEach(dogs::add);
        return "lesson10";
    }

    @PostMapping("/10/delete/{id}")
    public String lesson10delete(@PathVariable("id") long id)
    {
        taskRepository.deleteById(id);
        return "redirect:/10";
    }

    @PostMapping("/10/update/{id}")
    public String lesson10update(@PathVariable("id") long id,@Valid @ModelAttribute("task") Task task, BindingResult result, Model model )
    {
        model.addAttribute("task",taskRepository.findById(id).get());
        return "lesson10update";
    }
    @PostMapping("/10/finalizeupdate/{id}")
    public String lesson10FinalizeUpdate(@PathVariable("id") long id,@Valid @ModelAttribute("task") Task task, BindingResult result, Model model )
    {
        if (result.hasErrors())
        {
            //model.addAttribute("tasks",taskRepository.findAll());
            return "lesson10update";
        }
        //taskRepository.findById(id).get();
        taskRepository.save(task);
        return "redirect:/10";
    }


}
