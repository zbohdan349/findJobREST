package com.findJob.app.controller;

import com.findJob.app.model.Category;
import com.findJob.app.model.Company;
import com.findJob.app.model.Level;
import com.findJob.app.model.Vacancy;
import com.findJob.app.model.dto.FilterReq;
import com.findJob.app.model.dto.VacDto;
import com.findJob.app.service.CategoryServ;
import com.findJob.app.service.VacancyServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class StartController {

    @Autowired
    private VacancyServ vacancyServ;

    @Autowired
    private CategoryServ categoryServ;

    @GetMapping("/")
    public  String start(Model model){

        model.addAttribute("vacancies",vacancyServ.getRandom());
        return "index";
    }
    @GetMapping("/find")
    public  String find(Model model){
        model.addAttribute("filterReq", new FilterReq());
        model.addAttribute("categories",categoryServ.getAllCategories());
        model.addAttribute("vacancies",vacancyServ.getAll());
        model.addAttribute("levels", Level.values());
        return "filterP";
    }
    @GetMapping("/find1")
    public  String findWithParam(Model model,
                                 @DefaultValue("0")@RequestParam(required = false) Integer salary,
                                 @RequestParam(required = false) List<Level> levels,
                                 @RequestParam(required = false) Category category
                                 ){
        model.addAttribute("filterReq", new FilterReq());

        model.addAttribute("categories",categoryServ.getAllCategories());

        model.addAttribute("vacancies",vacancyServ.getFilter(salary,levels,category));

        model.addAttribute("levels", Level.values());

        return "filterP";
    }
    @GetMapping("/vacancy/{id}")
    public  String vacancy(Model model,@PathVariable Integer id){
        model.addAttribute("vacancy",vacancyServ.getCategoryById(id));
        return "vacancy";
    }
    @GetMapping("/addVacancy")
    public  String addVacancyGet(Model model){
        model.addAttribute("levels", Level.values());
        model.addAttribute("vacDto",new VacDto());
        model.addAttribute("categories",categoryServ.getAllCategories());
        return "addVacancy";
    }
    @PostMapping("/addVacancy")
    public  String addVacancy(@ModelAttribute VacDto vacDto, Model model){
        Vacancy vacancy = new Vacancy();

        vacancy.setName(vacDto.getName());
        vacancy.setBigDescription(vacDto.getBig());
        vacancy.setSalary(vacDto.getSalary());
        vacancy.setSmallDescription(vacDto.getSmall());
        vacancy.setLevel(vacDto.getLevel());
        Company company = new Company();
        company.setId(1);
        vacancy.setCategories(vacDto.getCategories());
        vacancy.setCompany(company);

        vacancyServ.save(vacancy);
        return "redirect:/find";
    }
}
