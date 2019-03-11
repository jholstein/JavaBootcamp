package com.javabootcamp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson03Controller
{
    @RequestMapping("/03")
    public static String lesson03()
    {

        return("lesson03");
    }
}
