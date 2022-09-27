package com.productwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping
    public String webApp(){
        return "index.html";
    }
}
