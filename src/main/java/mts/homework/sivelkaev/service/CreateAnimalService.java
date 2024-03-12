package mts.homework.sivelkaev.service;

import mts.homework.sivelkaev.animal.pet.species.Cat;
import mts.homework.sivelkaev.animal.pet.species.Dog;
import mts.homework.sivelkaev.animal.predator.species.Shark;
import mts.homework.sivelkaev.animal.predator.species.Wolf;

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
                Wolf wolf = new Wolf("wolfBreed", "wolfName", new Random().nextDouble(), "wolfCharacter");
                wolf.printInfo();
                break;
            case "Shark":
                Shark shark = new Shark("sharkBreed", "sharkName", new Random().nextDouble(), "sharkCharacter");
                shark.printInfo();
                break;
            case "Dog":
                Dog dog = new Dog("dogBreed", "dogName", new Random().nextDouble(), "dogCharacter");
                dog.printInfo();
                break;
            case "Cat":
                Cat cat = new Cat("catBreed", "catName", new Random().nextDouble(), "catCharacter");
                cat.printInfo();
                break;
        }
    }
}
