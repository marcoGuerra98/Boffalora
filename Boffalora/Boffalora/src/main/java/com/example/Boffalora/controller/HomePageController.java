package com.example.Boffalora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String redirectToProloco() {
        return "redirect:/boffalora.html";
    }
}
