package com.findJob.app.service;

import com.findJob.app.model.Client;
import com.findJob.app.model.Teamwork;
import com.findJob.app.model.Vacancy;
import com.findJob.app.repo.CategoryRepo;
import com.findJob.app.repo.ClientRepo;
import com.findJob.app.repo.TeamworkRepo;
import com.findJob.app.repo.VacancyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamWorkService {
    @Autowired
    private TeamworkRepo teamworkRepo;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private VacancyRepo vacancyRepo;

    public boolean addTeamWork(Integer vacancyId){
        Client currentClient = clientRepo.getById(authenticationService.getCurrentAccount().getId());
        Optional<Teamwork> teamwork =teamworkRepo.exist(vacancyId,currentClient.getId());
        if(teamwork.isEmpty()){
            Vacancy vacancy=vacancyRepo.getById(vacancyId);
            teamworkRepo.saveAndFlush(new Teamwork(currentClient,vacancy));
            return true;
        }else return false;
    }

    /*public boolean getTeamWorkBy(Integer vacancyId){
        Client currentClient = clientRepo.getById(authenticationService.getCurrentAccount().getId());
        Optional<Teamwork> teamwork =teamworkRepo.exist(vacancyId,currentClient.getId());
        if(teamwork.isEmpty()){
            teamworkRepo.addTeamWork(vacancyId,currentClient.getId());
            return true;
        }else return false;
    }*/
}
