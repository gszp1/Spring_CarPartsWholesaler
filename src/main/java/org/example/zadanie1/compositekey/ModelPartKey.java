package org.example.zadanie1.compositekey;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class ModelPartKey {

    private Long modelId;

    private Long partId;
}
