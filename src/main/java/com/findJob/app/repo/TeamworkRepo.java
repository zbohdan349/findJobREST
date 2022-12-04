package com.findJob.app.repo;

import com.findJob.app.model.Teamwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamworkRepo extends JpaRepository<Teamwork,Integer> {

    @Query("SELECT t FROM Teamwork t WHERE t.client.id =:id")
    List<Teamwork> findByClient(@Param("id") Integer id);

    @Query("SELECT t FROM Teamwork t WHERE t.vacancy.company.id =:id")
    List<Teamwork> findByCompany(@Param("id") Integer id);
}
