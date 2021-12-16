package com.findJob.app.service;

import com.findJob.app.model.Account;
import com.findJob.app.model.Role;
import com.findJob.app.model.User;
import com.findJob.app.model.dto.RegDto;
import com.findJob.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserServ {

    @Autowired
    private UserRepo userRepo;

    public void save(RegDto dto){

        Account account =new Account();

        account.setEmail(dto.getEmail());

        account.setRole(Role.USER);

        account.setPassword("{noop}"+dto.getPassword());

        account.setPhone(dto.getPhone());

        account.setLinkedIn(dto.getLinkedIn());

        User user = new User();

        user.setAccount(account);

        user.setName(dto.getName());

        user.setSecondName(dto.getSecondName());

        user.setDescription(dto.getDescription());

        userRepo.saveAndFlush(user);
    }
}
