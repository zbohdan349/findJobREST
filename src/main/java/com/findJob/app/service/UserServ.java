package com.findJob.app.service;

import com.findJob.app.model.Account;
import com.findJob.app.model.Client;
import com.findJob.app.model.dto.RegistrationReq;
import com.findJob.app.model.enums.Role;
import com.findJob.app.model.dto.RegDto;
import com.findJob.app.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserServ {

    @Autowired
    private ClientRepo userRepo;

    public void save(RegDto dto){

        Account account =new Account();

        account.setRole(Role.USER);

        account.setPassword("{noop}"+dto.getPassword());

        account.setPhone(dto.getPhone());

        account.setLinkedIn(dto.getLinkedIn());

        Client client = new Client();

        client.setAccount(account);

        client.setName(dto.getName());

        client.setSecondName(dto.getSecondName());

        client.setDescription(dto.getDescription());

        userRepo.save(client);
    }

    public void save(RegistrationReq req){

        Account account =new Account();

        account.setRole(Role.USER);

        account.setPassword("{noop}"+req.getPassword());

        account.setEmail(req.getEmail());

        Client client = new Client();

        client.setAccount(account);

        client.setName(req.getEmail());

        client.setDescription("User description");

        userRepo.save(client);
    }
}
