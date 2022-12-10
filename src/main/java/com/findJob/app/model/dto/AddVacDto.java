package com.findJob.app.model.dto;

import com.findJob.app.model.Category;
import com.findJob.app.model.Level;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class AddVacDto {
    private String name;

    private String smallDescription;

    private BigDecimal salary;

    private Set<Integer> categories;

    private Level level;

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Set<Integer> getCategories() {
        return categories;
    }

    public void setCategories(Set<Integer> categories) {
        this.categories = categories;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
