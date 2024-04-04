package org.example.zadanie1.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.zadanie1.compositekey.CarModelPartKey;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "car_model_part")
public class CarModelPart {

    @EmbeddedId
    private CarModelPartKey id;

    @ManyToOne
    @MapsId("partId")
    @JoinColumn(name = "part_part_id")
    private Part part;

    @ManyToOne
    @MapsId("modelId")
    @JoinColumn(name = "car_model_car_model_id")
    private CarModel carModel;
}
