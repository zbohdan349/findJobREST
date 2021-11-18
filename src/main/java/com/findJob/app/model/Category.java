package com.findJob.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Account>accounts;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Vacancy>vacancies;

    public Category() {
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

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
}
