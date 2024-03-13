package mts.homework.sivelkaev.animal.pet.species;

import mts.homework.sivelkaev.animal.pet.Pet;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
