package mts.homework.sivelkaev.service;

import mts.homework.starter.animal.Animal;
import java.util.*;

public interface CreateAnimalService {
    Map<String, List<Animal>> createAnimalGroup();

    default Map<String, List<Animal>> createEmptyAnimalMap() {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        animalMap.put("Wolf", new ArrayList<>());
        animalMap.put("Shark", new ArrayList<>());
        animalMap.put("Dog", new ArrayList<>());
        animalMap.put("Cat", new ArrayList<>());
        return animalMap;
    }
}
