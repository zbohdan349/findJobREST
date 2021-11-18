package com.findJob.app.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Role role;

    private String email;

    private String password;

    private String phone;

    private String linkedIn;

    private LocalDateTime localDateTime;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Category>categories;

    @OneToOne(mappedBy = "account")
    private Company company;

    @OneToOne(mappedBy = "account")
    private User user;

    public Account() {
    }

    public Account(Role role, String email, String password, String phone, String linkedIn, LocalDateTime localDateTime) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.linkedIn = linkedIn;
        this.localDateTime = localDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
