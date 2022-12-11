package com.findJob.app.repo;

import com.findJob.app.model.Teamwork;
import com.findJob.app.model.enums.CooperationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamworkRepo extends JpaRepository<Teamwork,Integer> {

    @Query("SELECT t FROM Teamwork t WHERE t.client.id =:id")
    List<Teamwork> findByClient(@Param("id") Integer id);

    @Query("SELECT t FROM Teamwork t " +
            "WHERE t.vacancy.company.id =:id")
    List<Teamwork> findByCompany(@Param("id") Integer id);

    @Query("SELECT t FROM Teamwork t " +
            "WHERE t.vacancy.company.id =:id " +
            "and t.status =:status")
    List<Teamwork> findByCompanyAndStatus(@Param("id") Integer id,
                                          @Param("status") CooperationStatus status);

    @Query("SELECT t FROM Teamwork t " +
            "WHERE t.vacancy.company.id =:company_id " +
            "and t.client.id =:client_id " +
            "and t.status =:status")
    Optional<Teamwork> findByCompanyAndClient(@Param("company_id") Integer companyId,
                                          @Param("client_id")Integer clientId,
                                          @Param("status") CooperationStatus status);

    @Query("SELECT t FROM Teamwork t " +
            "WHERE t.vacancy.id =:vacancy_id and t.client.id =:client_id")
    Optional<Teamwork> exist(@Param("vacancy_id") Integer vacancyId,
                             @Param("client_id") Integer clientId);

    @Query(value = "INSERT INTO Teamwork ('client_id','vacancy_id') VALUES (:client_id,:vacancy_id)",
    nativeQuery = true)
    void addTeamWork(@Param("vacancy_id") Integer vacancyId,
                     @Param("client_id") Integer clientId);
}
