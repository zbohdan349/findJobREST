package com.findJob.app.repo;

import com.findJob.app.model.Teamwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamworkRepo extends JpaRepository<Teamwork,Integer> {

    @Query("SELECT t FROM Teamwork t WHERE t.client.id =:id")
    List<Teamwork> findByClient(@Param("id") Integer id);

    @Query("SELECT t FROM Teamwork t WHERE t.vacancy.company.id =:id")
    List<Teamwork> findByCompany(@Param("id") Integer id);

    @Query("SELECT t FROM Teamwork t " +
            "WHERE t.vacancy.id =:vacancy_id and t.client.id =:client_id")
    Optional<Teamwork> exist(@Param("vacancy_id") Integer vacancyId,
                             @Param("client_id") Integer clientId);

    @Query(value = "INSERT INTO Teamwork ('client_id','vacancy_id') VALUES (:client_id,:vacancy_id)",
    nativeQuery = true)
    void addTeamWork(@Param("vacancy_id") Integer vacancyId,
                     @Param("client_id") Integer clientId);
}
