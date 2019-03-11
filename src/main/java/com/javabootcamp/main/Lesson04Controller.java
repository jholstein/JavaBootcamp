package com.javabootcamp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Lesson04Controller
{
    @RequestMapping("/04")
    public String lesson04()
    {


        return("lesson04");
    }
    @RequestMapping("/04confirm")
    public String lesson04confirm(@RequestParam(name="login",required=true,defaultValue="DefaultName"  ) String login, @RequestParam(name="password") String password, Model model)
    {
        model.addAttribute("loginval",login);
        model.addAttribute("passwordval", password);
        return("lesson04confirm");
    }
}
