package com.findJob.app.service;

import com.findJob.app.model.Category;
import com.findJob.app.model.Level;
import com.findJob.app.model.Vacancy;
import com.findJob.app.repo.VacancyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class VacancyServ {
    @Autowired
    private VacancyRepo vacancyRepo;

    public List<Vacancy> getRandom(){
        return vacancyRepo.findAll().subList(0,3);
    }

    public List<Vacancy> getAll(){
        return vacancyRepo.findAll();
    }

    public List<Vacancy> getFilter(Integer salary, List<Level> levels, Category category){
        if (salary==null)salary = 0;
        if (levels ==null){
            levels = new ArrayList<Level>();
            levels.addAll(List.of(Level.values()));
        }

        List<Vacancy>list =vacancyRepo.getByFilter(salary,levels);

        if (category!=null)
            list = list.stream().filter(vacancy -> vacancy.getCategories().contains(category)).toList();

        return list;
    }

    public Vacancy getCategoryById(Integer id){
        return vacancyRepo.getById(id);
    }



    public void save(Vacancy vacancy){
        vacancyRepo.save(vacancy);
    }


}
