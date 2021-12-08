package com.findJob.app.model.dto;

import com.findJob.app.model.Category;
import com.findJob.app.model.Level;

import java.util.Set;

public class FilterReq {
    private Category category;

    private Integer salary;

    private Set<Level> levels;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Set<Level> getLevels() {
        return levels;
    }

    public void setLevel(Set<Level> levels) {
        this.levels = levels;
    }
}
