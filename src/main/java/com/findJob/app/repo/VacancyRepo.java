package com.findJob.app.repo;

import com.findJob.app.model.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface VacancyRepo extends JpaRepository<Vacancy,Integer> {
    public Set<Vacancy>findByCategoriesInAndLevelInAndSalaryGreaterThan(
            @Param("categories")List<Category>categories,
            @Param("levels")List<Level> levels,
            @Param("Salary")BigDecimal Salary
    );

    public Vacancy findFirstByOrderBySalaryAsc();

    public Vacancy findFirstByOrderBySalaryDesc();

    @Query("SELECT v FROM Vacancy v WHERE v.company.id = :id")
    public List<Vacancy> findByCompany(@Param("id") Integer id);


}
