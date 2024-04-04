package org.example.zadanie1.compositekey;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class OrderDetailsKey implements Serializable {

    private Long orderId;

    private Long partId;
}


