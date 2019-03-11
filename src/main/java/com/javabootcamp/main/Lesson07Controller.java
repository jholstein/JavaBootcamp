package com.javabootcamp.main;

import com.javabootcamp.main.objects.TVshow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

@Controller
public class Lesson07Controller
{
    @GetMapping("/07")
    public String lesson07(Model model)
    {
        model.addAttribute("tvshow", new TVshow());
        return("lesson07");
    }
    @PostMapping("/07")
    public String lesson07confirm(@Valid TVshow tvshow, BindingResult result,Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("tvshow",tvshow);
            return "lesson07";
        }
        model.addAttribute("tvshow",tvshow);
        return "lesson07confirm";
    }
}
