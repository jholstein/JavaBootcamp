package com.javabootcamp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.javabootcamp.main.objects.*;

@Controller
public class Lesson04ExtraController
{
    @RequestMapping("/04extra")
    public String lesson04(Model model)
    {
        LoginData login = new LoginData();
        model.addAttribute("login", login);

        return("lesson04extra");
    }
    @RequestMapping("/04confirmextra")
    public String lesson04confirm(@ModelAttribute("login") LoginData login, Model model)
    {
        model.addAttribute("usernameval",login.getUsername());
        model.addAttribute("passwordval", login.getPassword());
        return("lesson04confirmextra");
    }
}


