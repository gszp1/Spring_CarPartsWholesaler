package org.example.zadanie1.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.zadanie1.compositekey.OrderDetailsKey;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetails {

    @EmbeddedId
    private OrderDetailsKey orderDetailsId;

    @ManyToOne
    @MapsId("partId")
    @JoinColumn(name = "part_id")
    private Part part;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    private Long quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

}
