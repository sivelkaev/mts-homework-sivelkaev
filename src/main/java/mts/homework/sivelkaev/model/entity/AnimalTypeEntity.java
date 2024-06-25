package mts.homework.sivelkaev.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "animal_type", schema = "animals")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalTypeEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "type")
    private String type;
}
