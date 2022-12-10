package com.findJob.app.model;

import com.findJob.app.model.enums.CooperationStatus;

import javax.persistence.*;

@Entity
public class Teamwork {

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

    public Teamwork() {
    }

    public Teamwork(Client client, Vacancy vacancy) {
        this.client = client;
        this.vacancy = vacancy;
        this.status = CooperationStatus.STARTED;
    }

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

    @Override
    public String toString() {
        return "Сooperation{" +
                "id=" + id +
                ", client=" + client +
                ", vacancy=" + vacancy +
                ", status=" + status +
                '}';
    }
}
