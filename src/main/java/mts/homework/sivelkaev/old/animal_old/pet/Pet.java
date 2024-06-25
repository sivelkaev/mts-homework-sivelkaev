package mts.homework.sivelkaev.old.animal_old.pet;

import mts.homework.sivelkaev.old.animal_old.AbstractAnimal;

import java.time.LocalDate;

public class Pet extends AbstractAnimal {
    public Pet(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
