package org.example.zadanie1.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "parts_models",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id")
    )
    private List<CarModel> models = new ArrayList<>();

    @OneToMany(mappedBy = "part")
    private List<OrderDetails> orderDetails = new ArrayList<>();

    @Column(unique = true, nullable = false, length = 50)
    private String name;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "units_in_stock", nullable = false)
    private Long unitsInStock;

    public Part(String name, BigDecimal unitPrice, Long unitsInStock) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
    }
}
