package com.microservices.usersservice.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false,unique = true)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;
}
