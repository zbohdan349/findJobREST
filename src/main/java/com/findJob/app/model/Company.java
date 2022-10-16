package com.findJob.app.model;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Company {
    @Id
    private int id;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Account account;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="company")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(name, company.name) && Objects.equals(description, company.description) && Objects.equals(account, company.account) && Objects.equals(vacancies, company.vacancies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, account, vacancies);
    }
}
