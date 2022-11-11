package com.findJob.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "client")
    private Set<Сooperation> сooperations;

    public Vacancy() {
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
        salary = salary;
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
}
