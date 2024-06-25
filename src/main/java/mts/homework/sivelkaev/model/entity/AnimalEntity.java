package mts.homework.sivelkaev.model.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "animal", schema = "animals")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    private AnimalTypeEntity type;

    @NotNull
    @Length(min = 1, max = 50)
    @Column(name = "breed")
    private String breed;

    @NotNull
    @Length(min = 1, max = 50)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "cost")
    private Double cost;

    @NotNull
    @Length(min = 1, max = 50)
    @Column(name = "character")
    private String character;

    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;
}
