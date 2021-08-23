package com.malsum.thymeleafdemo.model;

public interface Employee {
    void setId(int id);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setEmail(String email);

    String toString();

    int getId();

    String getFirstName();

    String getLastName();

    String getEmail();
}
