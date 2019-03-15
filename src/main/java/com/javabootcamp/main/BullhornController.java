package com.javabootcamp.main;

import com.cloudinary.utils.ObjectUtils;
import com.javabootcamp.main.config.CloudinaryConfig;
import com.javabootcamp.main.objects.Actor;
import com.javabootcamp.main.objects.BullhornPost;
import com.javabootcamp.main.objects.Task;
import com.javabootcamp.main.repos.BullhornPostRepository;
import com.javabootcamp.main.repos.TaskRepository;
import com.javabootcamp.main.util.ImageResizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@Controller
public class BullhornController
{

    @Autowired
    BullhornPostRepository bullhornPostRepository;

    @Autowired
    CloudinaryConfig cloudinaryConfig;


    @GetMapping("/bullhorn")
    public String bullhorn(Model model)
    {
        model.addAttribute("post", new BullhornPost());
        //model.addAttribute("posts", bullhornPostRepository.findAll());
        ArrayList<BullhornPost> bhList = new ArrayList<BullhornPost>();
        for (BullhornPost b : bullhornPostRepository.findAll())
        {
            bhList.add(b);
        }
        Collections.reverse(bhList);
        model.addAttribute("posts", bhList);

        return("bullhorn");
    }






    @PostMapping("/bullhorn")
    public String bullhornAddPost(@Valid @ModelAttribute("post") BullhornPost post, BindingResult result, @RequestParam("file") MultipartFile file, Model model)
    {

        if (result.hasErrors())
        {

            model.addAttribute("posts",bullhornPostRepository.findAll());
            model.addAttribute("post",post);
            return "bullhorn";
        }

        if (file.isEmpty())
        {
            bullhornPostRepository.save(post);
            return "redirect:/bullhorn";
        }
        else {
            try {
                byte[] scaledImage = ImageResizer.resizeByte(file.getBytes(),300, 500);
                Map uploadResult = cloudinaryConfig.upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                post.setPostImage(uploadResult.get("url").toString());
                bullhornPostRepository.save(post);
            } catch (IOException e) {
                e.printStackTrace();
                return "redirect:/bullhorn";
            }
            return "redirect:/bullhorn";
        }
    }







    @PostMapping("/bullhorn/delete/{id}")
    public String bullhornDelete(@PathVariable("id") long id)
    {
        bullhornPostRepository.deleteById(id);
        return "redirect:/bullhorn";
    }

    @PostMapping("/bullhorn/update/{id}")
    public String bullhornUpdate(@PathVariable("id") long id,@Valid @ModelAttribute("post") BullhornPost post, BindingResult result, Model model )
    {
        model.addAttribute("post",bullhornPostRepository.findById(id).get());
        return "/bullhornupdate";
    }
    @PostMapping("/bullhorn/finalizeupdate/{id}")
    public String bullhornFinalizeUpdate(@PathVariable("id") long id,@Valid @ModelAttribute("post") BullhornPost post, BindingResult result, Model model )
    {
        if (result.hasErrors())
        {
            //model.addAttribute("tasks",taskRepository.findAll());
            return "/bullhornupdate";
        }
        //taskRepository.findById(id).get();
        bullhornPostRepository.save(post);
        return "redirect:/bullhorn";
    }


}
