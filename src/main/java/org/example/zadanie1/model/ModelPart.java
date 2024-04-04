package org.example.zadanie1.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.zadanie1.compositekey.ModelPartKey;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "models_parts")
public class ModelPart {

    @EmbeddedId
    private ModelPartKey modelPartId;

    @ManyToOne
    @MapsId("partId")
    @JoinColumn(name = "part_part_id")
    private Part part;

    @ManyToOne
    @MapsId("modelId")
    @JoinColumn(name = "model_model_id")
    private Model model;
}
