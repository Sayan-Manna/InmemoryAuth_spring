package com.securitydemo.inmemorysecurity.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean active;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles", // name of the join table
//            joinColumns = @JoinColumn(name = "user_id"), // column in the join table that refers to User
//            inverseJoinColumns = @JoinColumn(name = "role_id")) // column in the join table that refers to Role
//    private Set<String> roles = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER) //
    @CollectionTable(name = "user_roles")
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

}

