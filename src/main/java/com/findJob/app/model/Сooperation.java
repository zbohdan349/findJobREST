package com.findJob.app.model;

import com.findJob.app.model.enums.CooperationStatus;

import javax.persistence.*;

@Entity
public class Сooperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @Enumerated(EnumType.STRING)
    private CooperationStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public CooperationStatus getStatus() {
        return status;
    }

    public void setStatus(CooperationStatus status) {
        this.status = status;
    }
}
