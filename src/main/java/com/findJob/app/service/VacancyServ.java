package com.findJob.app.service;

import com.findJob.app.model.*;
import com.findJob.app.model.dto.VacDto;
import com.findJob.app.repo.CategoryRepo;

import com.findJob.app.repo.ClientRepo;
import com.findJob.app.repo.VacancyRepo;
import com.findJob.app.repo.TeamworkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Service
public class VacancyServ {

    private final String SERVER_URL = "http://localhost:8080/";
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private VacancyRepo vacancyRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private TeamworkRepo teamworkRepo;



    public BigDecimal getMinSalary(){
        return vacancyRepo.findFirstByOrderBySalaryAsc().getSalary();
    }
    public BigDecimal getMaxSalary(){
        return vacancyRepo.findFirstByOrderBySalaryDesc().getSalary();
    }

    public List<VacDto> getRandom(){
        return vacancyRepo.findAll().subList(0,3).stream().map(this::convertToDTO).toList();
    }

    public List<VacDto> getAll(){
        return vacancyRepo.findAll().stream().map(this::convertToDTO).toList();
    }

    public List<VacDto> getFilter(BigDecimal salary, List<Level> levels, List<Integer> categories){
        if (salary==null)salary = BigDecimal.valueOf(0);
        if (levels ==null|| levels.isEmpty()){
            levels = new ArrayList<Level>();
            levels.addAll(List.of(Level.values()));
        }
        List<Category> categoryList;
        if(categories==null || categories.isEmpty()){
            categoryList = (categoryRepo.findAll());;
        }
        else categoryList = categories.stream().map(id -> {
            Category c = new Category();
            c.setId(id);
            return c;
        }).toList();

        Set<Vacancy>list = vacancyRepo.findByCategoriesInAndLevelInAndSalaryGreaterThan(categoryList,levels,BigDecimal.valueOf(salary.intValue()-1));

       /* if (categories!=null)
            list = list.stream()
                    .filter(vacancy ->
                            new HashSet<>(categories)
                                    .containsAll(
                                            vacancy.getCategories().stream()) ).toList();
*/
        return list.stream().map(this::convertToDTO).toList();
    }
    public VacDto getCategoryById(Integer id){
        Vacancy vacancy = vacancyRepo.getById(id);
        VacDto dto = new VacDto();

        dto.setId(vacancy.getId());
        dto.setName(vacancy.getName());
        dto.setBigDescription(vacancy.getBigDescription());
        dto.setSalary(vacancy.getSalary());
        dto.setCategories(vacancy.getCategories());
        dto.getCompany().put("id",vacancy.getCompany().getId());
        dto.getCompany().put("name",vacancy.getCompany().getName());
        dto.getCompany().put("img",SERVER_URL+"files/"+ vacancy.getCompany().getId());

        return dto;
    }

    public void save(Vacancy vacancy){
        vacancyRepo.save(vacancy);
    }

    public List<VacDto> getVacanciesByCompany(){

        Account account = authenticationService.getCurrentAccount();
        List<Vacancy> vacancies = new ArrayList<>();
        List<Teamwork> list;
        switch (account.getRole()){
            case COMPANY:
                list =teamworkRepo.findByCompany(account.getId());
                vacancies.addAll(list.stream().map(Teamwork::getVacancy).toList());
                break;

            case USER:
                list =teamworkRepo.findByClient(account.getId());
                vacancies.addAll(list.stream().map(Teamwork::getVacancy).toList());
                break;
        }

        return vacancies.stream().map(this::convertToDTO).toList();
    }

    private VacDto convertToDTO(Vacancy vacancy){
        VacDto dto = new VacDto();

        dto.setId(vacancy.getId());
        dto.setName(vacancy.getName());
        dto.setSmallDescription(vacancy.getSmallDescription());
        dto.setSalary(vacancy.getSalary());
        dto.setCategories(vacancy.getCategories());
        dto.getCompany().put("id",vacancy.getCompany().getId());
        dto.getCompany().put("name",vacancy.getCompany().getName());
        dto.getCompany().put("img",SERVER_URL+"files/"+ vacancy.getCompany().getId());

        return dto;
    }
}
