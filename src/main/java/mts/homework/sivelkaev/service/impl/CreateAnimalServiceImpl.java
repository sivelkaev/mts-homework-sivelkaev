package mts.homework.sivelkaev.service.impl;

import mts.homework.sivelkaev.animal.Animal;
import mts.homework.sivelkaev.service.CreateAnimalService;

import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public Map<String, List<Animal>> createAnimalGroup() {
        var animalMap = createEmptyAnimalMap();

        int i = 0;
        do {
            Animal animal = createAnimal();
            animalMap.get(animal.getClass().getSimpleName()).add(animal);
            i++;
        }
        while (i < 10);

        return animalMap;
    }

    public void createOtherAnimalGroup() {
        for(int i = 0; i < 10; i++) {
            createAnimal();
        }
    }

    public void createOtherAnimalGroup(int n) {
        for(int i = 0; i < n; i++) {
            createAnimal();
        }
    }
}
