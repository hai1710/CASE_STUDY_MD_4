package com.demo.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String age;
    private String sex;
    private String image;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "role_id9")
    private Role role;

    public Account() {
    }

    public Account(String email, String password, String name, String age, String sex, String image, Boolean status, Address address, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.image = image;
        this.status = status;
        this.address = address;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
