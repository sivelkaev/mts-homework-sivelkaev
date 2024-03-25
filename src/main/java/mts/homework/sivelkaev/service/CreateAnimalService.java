package mts.homework.sivelkaev.service;

import mts.homework.sivelkaev.animal.pet.species.Cat;
import mts.homework.sivelkaev.animal.pet.species.Dog;
import mts.homework.sivelkaev.animal.predator.species.Shark;
import mts.homework.sivelkaev.animal.predator.species.Wolf;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public interface CreateAnimalService {
    List<String> animalTypeList = List.of("Wolf", "Shark", "Dog", "Cat");

    default void createAnimalGroup() {
        int i = 0;
        while(i < 10) {
            createAnimal();
            i++;
        }
    }

    default void createAnimal() {
        String animalType = animalTypeList.get(new Random().nextInt(0,4));

        switch(animalType) {
            case "Wolf":
                Wolf wolf = new Wolf("wolfBreed", "wolfName", new Random().nextDouble(), "wolfCharacter", getRandomLocalDate());
                wolf.printInfo();
                break;
            case "Shark":
                Shark shark = new Shark("sharkBreed", "sharkName", new Random().nextDouble(), "sharkCharacter", getRandomLocalDate());
                shark.printInfo();
                break;
            case "Dog":
                Dog dog = new Dog("dogBreed", "dogName", new Random().nextDouble(), "dogCharacter", getRandomLocalDate());
                dog.printInfo();
                break;
            case "Cat":
                Cat cat = new Cat("catBreed", "catName", new Random().nextDouble(), "catCharacter", getRandomLocalDate());
                cat.printInfo();
                break;
        }
    }

    private LocalDate getRandomLocalDate() {
        long minDay = LocalDate.of(2000, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = new Random().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
