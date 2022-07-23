package com.ziojio.javaweb.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Account {
    @Id
    @GeneratedValue
    public int id;
    public String name;
    public String email;
    public String password;

    private String firstName;
    private String lastName;

    public Account() {}

    public Account(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Account[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
