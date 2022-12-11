package com.findJob.app.service;

import com.findJob.app.model.Client;
import com.findJob.app.model.Company;
import com.findJob.app.model.Teamwork;
import com.findJob.app.model.Vacancy;
import com.findJob.app.model.enums.CooperationStatus;
import com.findJob.app.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TeamWorkService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private TeamworkRepo teamworkRepo;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private CompanyRepo companyRepo;
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

    public HashMap<String,Object> getActiveTeamWork(){
        Company company = companyRepo.getByAccount(authenticationService.getCurrentAccount());
        List<Teamwork> teamworks = teamworkRepo.findByCompanyAndStatus(company.getId(), CooperationStatus.STARTED);
        HashMap<String,Object> map = new HashMap<>();
        map.put("clients",teamworks.stream().map(teamwork -> teamwork.getClient().getAccount().getEmail()));
        return map;
    }
    public boolean updateTeamWorkStatus(String email){
        Integer clientId = accountRepo.findByEmail(email).get().getId();
        Integer currentCompany =authenticationService.getCurrentAccount().getId();
        Optional<Teamwork> currTeamWork = teamworkRepo
                .findByCompanyAndClient(currentCompany,clientId,CooperationStatus.STARTED);
        if(currTeamWork.isPresent()){
            Teamwork teamwork = currTeamWork.get();
            teamwork.setStatus(CooperationStatus.FINISHED);
            teamworkRepo.save(teamwork);
            return true;
        }
        return false;

    }
}
