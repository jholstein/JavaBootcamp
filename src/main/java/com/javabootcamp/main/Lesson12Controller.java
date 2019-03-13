package com.javabootcamp.main;

import com.javabootcamp.main.objects.Car;
import com.javabootcamp.main.repos.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class Lesson12Controller
{

    @RequestMapping("/12")
    public String lesson12index(){return "lesson12index";}

    @RequestMapping("/12/about")
    public String lesson12about(){return "lesson12about";}

    @RequestMapping("/12/contact")
    public String lesson12contact(){return "lesson12contact";}



}



