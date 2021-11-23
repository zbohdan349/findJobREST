package com.findJob.app.service;

import com.findJob.app.model.Vacancy;
import com.findJob.app.repo.VacancyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
}
