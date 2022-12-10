package com.findJob.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String smallDescription;

    @Lob
    private String bigDescription;

    private String name;

    private Boolean visible;

    @Enumerated(EnumType.STRING)
    private Level level;

    private BigDecimal salary;

    private LocalDateTime time;

    @JsonIgnore
    @ManyToMany(mappedBy = "vacancies")
    private Set<Category>categories;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    @OneToMany(mappedBy = "client")
    private List<Teamwork> teamworks;

    public Vacancy() {
    }

    public Vacancy(Integer vacancyId) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String description) {
        this.smallDescription = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getBigDescription() {
        return bigDescription;
    }

    public void setBigDescription(String bigDescription) {
        this.bigDescription = bigDescription;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Teamwork> getСooperations() {
        return teamworks;
    }

    public void setСooperations(List<Teamwork> teamworks) {
        this.teamworks = teamworks;
    }
}
