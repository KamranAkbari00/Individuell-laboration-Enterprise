package com.exemple.wigellmember.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String firstName;

    @Column(length = 40, nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    private String phone;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @JsonIgnoreProperties("members")
    @ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "address_id", referencedColumnName = "id")
    private Address address;

    public Member() {}

    public Member(Address address, LocalDate dateOfBirth, String phone, String email, String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
