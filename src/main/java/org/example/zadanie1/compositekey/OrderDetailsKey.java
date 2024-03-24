package org.example.zadanie1.compositekey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class OrderDetailsKey implements Serializable {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "part_id")
    private Long partId;
}


