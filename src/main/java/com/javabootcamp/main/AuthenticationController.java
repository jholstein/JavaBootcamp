package com.javabootcamp.main;


import com.javabootcamp.main.objects.BullhornPost;
import com.javabootcamp.main.objects.User;
import com.javabootcamp.main.repos.TaskRepository;
import com.javabootcamp.main.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthenticationController
{
    @Autowired
    UserRepository userRepository;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String confirmLogin(@Valid @ModelAttribute("user") User user, BindingResult result, Model model )
    {
        User verificationUser = userRepository.findById(user.getUsername()).get();

        if (verificationUser.getPassword() == user.getPassword()) {

        }

        return "/";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping("/register")
    public String confirmRegister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ) {
        return "/";
    }


}
