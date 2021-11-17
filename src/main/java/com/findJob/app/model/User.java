package com.findJob.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private int id;

    private String name;

    private String secondName;

    @OneToOne
    @JoinColumn(name = "id")
    private Account account;

    @OneToMany(mappedBy = "user")
    private Set<Skill>skills;

    public User() {
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
