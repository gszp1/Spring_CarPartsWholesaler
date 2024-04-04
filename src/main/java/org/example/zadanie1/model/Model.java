package org.example.zadanie1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "car_models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long modelId;

    @OneToMany(mappedBy = "carModel")
    private List<CarModelPart> parts = new ArrayList<>();

    @Column(unique = true, nullable = false, length = 50)
    private String name;
}
