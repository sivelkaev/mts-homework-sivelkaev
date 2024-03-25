package mts.homework.sivelkaev.service;

import mts.homework.sivelkaev.animal.Animal;
import mts.homework.sivelkaev.animal.pet.species.Cat;
import mts.homework.sivelkaev.animal.pet.species.Dog;
import mts.homework.sivelkaev.animal.predator.species.Shark;
import mts.homework.sivelkaev.animal.predator.species.Wolf;

import java.time.LocalDate;
import java.util.*;

public interface CreateAnimalService {
    List<String> animalTypeList = List.of("Wolf", "Shark", "Dog", "Cat");

    default Map<String, List<Animal>> createAnimalGroup() {
        var animalMap = createEmptyAnimalMap();

        int i = 0;
        while(i < 10) {
            Animal animal = createAnimal();
            animalMap.get(animal.getClass().getSimpleName()).add(animal);
            i++;
        }

        return animalMap;
    }

    default Animal createAnimal() {
        String animalType = animalTypeList.get(new Random().nextInt(0,4));

        switch(animalType) {
            case "Wolf":
                Wolf wolf = new Wolf("wolfBreed", "wolfName", new Random().nextDouble(), "wolfCharacter", getRandomLocalDate());
                wolf.printInfo();
                return wolf;
            case "Shark":
                Shark shark = new Shark("sharkBreed", "sharkName", new Random().nextDouble(), "sharkCharacter", getRandomLocalDate());
                shark.printInfo();
                return shark;
            case "Dog":
                Dog dog = new Dog("dogBreed", "dogName", new Random().nextDouble(), "dogCharacter", getRandomLocalDate());
                dog.printInfo();
                return dog;
            case "Cat":
                Cat cat = new Cat("catBreed", "catName", new Random().nextDouble(), "catCharacter", getRandomLocalDate());
                cat.printInfo();
                return cat;
            default:
                return null;
        }
    }

    private LocalDate getRandomLocalDate() {
        long minDay = LocalDate.of(2000, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = new Random().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    default Map<String, List<Animal>> createEmptyAnimalMap() {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        animalMap.put("Wolf", new ArrayList<>());
        animalMap.put("Shark", new ArrayList<>());
        animalMap.put("Dog", new ArrayList<>());
        animalMap.put("Cat", new ArrayList<>());
        return animalMap;
    }
}
