package com.findJob.app.repo;

import com.findJob.app.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepo extends JpaRepository<Vacancy,Integer> {
}
