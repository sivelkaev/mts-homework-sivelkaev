package mts.homework.sivelkaev.animal;

import java.time.LocalDate;

public interface Animal {
    String getBreed();

    String getName();

    Double getCost();

    String getCharacter();

    LocalDate getBirthDate();
}
