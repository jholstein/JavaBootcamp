package com.javabootcamp.main;

import com.javabootcamp.main.objects.Dog;
import com.javabootcamp.main.objects.TVshow;
import com.javabootcamp.main.repos.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Lesson08Controller
{

    @Autowired
    DogRepository dogRepository;


    @GetMapping("/08")
    public String lesson08(Model model)
    {
        model.addAttribute("dog", new Dog());
        model.addAttribute("dogs", dogRepository.findAll());
        return("lesson08");
    }
    @PostMapping("/08")
    public String lesson08confirm(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {

            model.addAttribute("dogs",dogRepository.findAll());


            return "lesson08confirm";
        }


        dogRepository.save(dog);


        model.addAttribute("dog",dog);
        model.addAttribute("dogs",dogRepository.findAll());

        //dogRepository.findAll().forEach(dogs::add);
        return "lesson08confirm";
    }
}
