package com.javabootcamp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson02Controller
{
    @RequestMapping("/02")
    public static String lesson02(Model model)
    {
        model.addAttribute("lesson02text","This is Lesson 2");
        return("lesson02");
    }
}
