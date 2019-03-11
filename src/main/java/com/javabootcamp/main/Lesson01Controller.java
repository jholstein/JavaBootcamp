package com.javabootcamp.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Controller
{
    @RequestMapping("/01")
    public static String lesson01()
    {
        return("lesson01");
    }
}
