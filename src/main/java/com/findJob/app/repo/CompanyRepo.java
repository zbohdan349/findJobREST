package com.findJob.app.repo;

import com.findJob.app.model.Account;
import com.findJob.app.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {
    Company getByAccount(Account account);
}
