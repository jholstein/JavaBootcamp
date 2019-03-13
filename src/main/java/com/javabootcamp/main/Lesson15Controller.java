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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@Controller
public class Lesson15Controller
{

    @Autowired
    TaskRepository taskRepository;


    @GetMapping("/15")
    public String lesson15(Model model)
    {
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskRepository.findAll());
        return("lesson15");
    }
    @PostMapping("/15")
    public String lesson15confirm(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model)
    {
        //LocalDate date1=LocalDate.parse(task.getDueDateString(), DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));

        if (result.hasErrors())
        {
            //|| LocalDate.now().compareTo(task.getDueDate()) > 0
            System.out.println("HAS ERROR");
            System.out.println(result.getAllErrors());
            model.addAttribute("tasks",taskRepository.findAll());
            return "lesson15";
        }

        System.out.println("NO ERROR");
        taskRepository.save(task);



        model.addAttribute("task",task);
        model.addAttribute("tasks",taskRepository.findAll());


        //dogRepository.findAll().forEach(dogs::add);
        return "lesson15";
    }

    @PostMapping("/15/delete/{id}")
    public String lesson15delete(@PathVariable("id") long id)
    {
        taskRepository.deleteById(id);
        return "redirect:/15";
    }

    @PostMapping("/15/update/{id}")
    public String lesson15update(@PathVariable("id") long id,@Valid @ModelAttribute("task") Task task, BindingResult result, Model model )
    {
        model.addAttribute("task",taskRepository.findById(id).get());
        return "lesson15update";
    }
    @PostMapping("/15/finalizeupdate/{id}")
    public String lesson15FinalizeUpdate(@PathVariable("id") long id,@Valid @ModelAttribute("task") Task task, BindingResult result, Model model )
    {
        if (result.hasErrors())
        {
            //model.addAttribute("tasks",taskRepository.findAll());
            return "lesson15update";
        }
        //taskRepository.findById(id).get();
        taskRepository.save(task);
        return "redirect:/15";
    }


}
