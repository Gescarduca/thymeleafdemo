package com.malsum.thymeleafdemo.model;

import com.malsum.thymeleafdemo.CustomAnnotations.BasicRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeImp{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    @NotEmpty(message = "first name cannot be empty")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "roles")
    @BasicRole()
    private String roles;
    @Column(name = "active")
    private boolean active;

}
