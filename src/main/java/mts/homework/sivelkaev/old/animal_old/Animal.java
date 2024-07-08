package mts.homework.sivelkaev.old.animal_old;

import java.time.LocalDate;

public interface Animal {
    String getBreed();

    String getName();

    Double getCost();

    String getCharacter();

    LocalDate getBirthDate();

    String getSecretInformation();

    void setSecretInformation(String secretInformation);

    void printInfo();
}
