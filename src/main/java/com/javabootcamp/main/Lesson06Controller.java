package com.javabootcamp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.javabootcamp.main.objects.Song;

@Controller
public class Lesson06Controller
{
    @GetMapping("/06")
    public String lesson04Get(Model model)
    {
        model.addAttribute("song",new Song());
        return("lesson06");
    }
    @PostMapping("/06")
    public String lesson04Post(@ModelAttribute Song song, Model model)
    {
        model.addAttribute("song",song);
        return("lesson06confirm");
    }


}
