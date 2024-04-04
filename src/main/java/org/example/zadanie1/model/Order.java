package org.example.zadanie1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails = new ArrayList<>();

    @Column(name = "placing_date", nullable = false)
    private LocalDate placingDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(nullable = false)
    private Integer status;

    public Order(LocalDate placingDate, LocalDate deliveryDate, Integer status) {
        this.placingDate = placingDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public Order(LocalDate placingDate, LocalDate deliveryDate, Integer status, User user) {
        this.placingDate = placingDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.user = user;
    }
}
