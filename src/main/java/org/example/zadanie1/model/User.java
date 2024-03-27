package org.example.zadanie1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String surname;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(length = 13)
    private String phoneNumber;

    public User(String username, String firstName, String surname, String email, String phoneNumber) {
        this.username = username;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        orders = new ArrayList<>();
    }
}