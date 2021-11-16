package com.findJob.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public  String start(){
        int i =0;
        return "index";
    }
}
