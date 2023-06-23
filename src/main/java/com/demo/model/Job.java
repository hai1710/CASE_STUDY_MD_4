package com.demo.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double salary;
    @ManyToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address_job;
    private String vacancies;
    private Long Experience;
    private String job_form;
    private Date date;
    private String description;
    private String quantity_job;
    private String sex;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public Job() {
    }

    public Job(String title, Double salary, Address address_job, String vacancies, Long experience, String job_form, Date date, String description, String quantity_job, String sex, Company company) {
        this.title = title;
        this.salary = salary;
        this.address_job = address_job;
        this.vacancies = vacancies;
        Experience = experience;
        this.job_form = job_form;
        this.date = date;
        this.description = description;
        this.quantity_job = quantity_job;
        this.sex = sex;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Address getAddress_job() {
        return address_job;
    }

    public void setAddress_job(Address address_job) {
        this.address_job = address_job;
    }

    public String getVacancies() {
        return vacancies;
    }

    public void setVacancies(String vacancies) {
        this.vacancies = vacancies;
    }

    public Long getExperience() {
        return Experience;
    }

    public void setExperience(Long experience) {
        Experience = experience;
    }

    public String getJob_form() {
        return job_form;
    }

    public void setJob_form(String job_form) {
        this.job_form = job_form;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity_job() {
        return quantity_job;
    }

    public void setQuantity_job(String quantity_job) {
        this.quantity_job = quantity_job;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
