package com.findJob.app.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {
    @Id
    private int id;

    private String name;

    private String description;

    @OneToOne
    @JoinColumn(name = "id")
    private Account account;

    @OneToMany(mappedBy="company")
    private Set<Vacancy>vacancies;

    public Company() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}