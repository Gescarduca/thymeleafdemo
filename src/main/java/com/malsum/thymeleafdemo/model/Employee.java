package com.malsum.thymeleafdemo.model;

public interface Employee {
    void setId(int id);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setEmail(String email);

    void setUserName(String username);

    void setPassword(String password);

    void setRoles(String roles);

    void setActive(boolean active);

    String toString();

    int getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getUserName();

    String getPassword();

    String getRoles();

    boolean isActive();


}
