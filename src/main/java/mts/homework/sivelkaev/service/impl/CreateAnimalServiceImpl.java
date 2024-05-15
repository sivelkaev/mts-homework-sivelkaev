package mts.homework.sivelkaev.service.impl;

import mts.homework.sivelkaev.animal.Animal;
import mts.homework.sivelkaev.service.CreateAnimalService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    private static final String FILE_PATH = "C:\\Users\\gasivelkay\\Documents\\GitHub\\mts-homework-sivelkaev\\src\\main\\resources\\logData.txt";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public Map<String, List<Animal>> createAnimalGroup() {
        var animalMap = createEmptyAnimalMap();

        int i = 0;
        do {
            Animal animal = createAnimal();
            logAnimal(i, animal);
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

    private void logAnimal(int i, Animal animal) {
        String text = i + " " + animal.getBreed() + " " + animal.getName() + " " + animal.getCost() + animal.getBirthDate().format(formatter) + " " + animal.getSecretInformation() + "\n";

        try {
            Files.write(Paths.get(FILE_PATH), text.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
