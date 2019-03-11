package com.javabootcamp.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestingController
{
    @RequestMapping("/testing")
    public String testingResolver() {
        return "testing";
    }


}
