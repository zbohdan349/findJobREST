package com.findJob.app.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {
    @Id
    private int id;

    private String name;

    private String secondName;

    private String description;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Account account;

    @OneToMany(mappedBy="vacancy")
    private List<Teamwork> teamworks;

    public Client() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Teamwork> getTeamworks() {
        return teamworks;
    }

    public void setTeamworks(List<Teamwork> teamworks) {
        this.teamworks = teamworks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(name, client.name) && Objects.equals(secondName, client.secondName) && Objects.equals(description, client.description) && Objects.equals(account, client.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, secondName, description, account);
    }
}
