package com.findJob.app.model.dto;

import com.findJob.app.model.Category;
import com.findJob.app.model.Level;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VacDto {
    private Integer id;
    private String name;
    private String smallDescription;

    private String BigDescription;
    private BigDecimal salary;

    private Map<String,Object> company;

    private Set<Category> categories;

    public VacDto() {
        company =new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Map<String, Object> getCompany() {
        return company;
    }
    public void setCompany(Map<String, Object> company) {
        this.company = company;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getBigDescription() {
        return BigDescription;
    }

    public void setBigDescription(String bigDescription) {
        BigDescription = bigDescription;
    }
}
