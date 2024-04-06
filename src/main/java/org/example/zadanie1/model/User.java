package org.example.zadanie1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(length = 50)
    private String surname;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "phone_number", length = 13)
    private String phoneNumber;

    public User(String username, String firstName, String surname, String email, String phoneNumber) {
        this.username = username;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(Long userId, String username, String firstName, String surname, String email, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}