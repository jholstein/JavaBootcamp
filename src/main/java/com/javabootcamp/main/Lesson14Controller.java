package com.javabootcamp.main;

import com.cloudinary.utils.ObjectUtils;
import com.javabootcamp.main.config.CloudinaryConfig;
import com.javabootcamp.main.objects.Actor;
import com.javabootcamp.main.repos.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class Lesson14Controller
{
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    CloudinaryConfig cloudinaryConfig;


    @RequestMapping("/14")
    public String lesson14listActor(Model model)
    {
        model.addAttribute("actors", actorRepository.findAll());
        return "lesson14listActors";
    }

    @GetMapping("/14/add")
    public String lesson14createActor(Model model)
    {
        model.addAttribute("actor", new Actor());
        return "lesson14addActor";
    }
    @PostMapping("/14/add")
    public String lesson14addActor(@Valid @ModelAttribute("actor") Actor actor, @RequestParam("file") MultipartFile file)
    {
        if (file.isEmpty())
        {
            return "redirect:/14/add";
        }
        try
        {
            Map uploadResult=cloudinaryConfig.upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            actor.setHeadshot(uploadResult.get("url").toString());
            actorRepository.save(actor);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "redirect:/14/add";
        }
        return "redirect:/14";
    }









}



