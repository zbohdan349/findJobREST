package com.findJob.app.controller;

import com.findJob.app.model.Company;
import com.findJob.app.model.Vacancy;
import com.findJob.app.service.VacancyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class StartController {

    @Autowired
    private VacancyServ vacancyServ;

    @GetMapping("/")
    public  String start(Model model){

        model.addAttribute("vacancies",vacancyServ.getRandom());
        return "index";
    }
    @GetMapping("/find")
    public  String find(Model model){

        model.addAttribute("vacancies",vacancyServ.getAll());
        return "filterP";
    }
}
