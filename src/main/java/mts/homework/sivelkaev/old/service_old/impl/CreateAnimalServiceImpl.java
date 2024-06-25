package mts.homework.sivelkaev.old.service_old.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mts.homework.starter.animal.Animal;
import mts.homework.sivelkaev.old.service_old.CreateAnimalService;
import mts.homework.starter.service.AnimalService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateAnimalServiceImpl implements CreateAnimalService {
    private static final String FILE_PATH = "C:\\Users\\gasivelkay\\Documents\\GitHub\\mts-homework-sivelkaev\\src\\main\\resources\\logData.txt";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private final AnimalService animalService;

    @Override
    public Map<String, List<Animal>> createAnimalGroup() {
        var animalMap = createEmptyAnimalMap();

        int i = 0;
        do {
            Animal animal = animalService.createAnimal();
            logAnimal(i, animal);
            animalMap.get(animal.getClass().getSimpleName()).add(animal);
            i++;
        }
        while (i < 10);

        return animalMap;
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
