package mts.homework.sivelkaev.old.repository_old.impl;

import lombok.RequiredArgsConstructor;
import mts.homework.sivelkaev.old.repository_old.AnimalRepository;
import mts.homework.starter.animal.Animal;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;
import mts.homework.sivelkaev.exception.InvalidAnimalException;
import mts.homework.sivelkaev.old.service_old.CreateAnimalService;
import mts.homework.sivelkaev.old.service_old.SearchService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AnimalRepositoryImpl implements AnimalRepository {
    private final CreateAnimalService createAnimalService;
    private final SearchService searchService;

    /*@PostConstruct
    public void initService() {
        createAnimalService.createAnimalGroup();
    }*/

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animalList) throws InvalidAnimalException, InvalidAnimalBirthDateException {
        Map<String, LocalDate> datesMap = animalList.stream()
                .filter(animal -> {
                    try {
                        return searchService.checkLeapYearAnimal(animal);
                    } catch (InvalidAnimalBirthDateException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toMap(animal -> animal.getClass().getSimpleName() + " " + animal.getName(), animal -> animal.getBirthDate()));

        return datesMap;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animalList, Integer age) {
        Map<Animal, Integer> agesMap;
        Animal oldestAnimal = null;

        agesMap = animalList.stream()
                    .anyMatch(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears() >= age)
                ? animalList.stream()
                    .filter(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears() >= age)
                    .collect(Collectors.toMap(animal -> animal, animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears()))
                : animalList.stream()
                    .min(Comparator.comparing(Animal::getBirthDate))
                    .stream()
                    .collect(Collectors.toMap(animal -> animal, animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears()));

        return agesMap;
    }

    @Override
    public Map<String, List<Animal>> findDuplicate(List<Animal> animalList) {
        Map<String, List<Animal>> duplicatesMap = new HashMap<>();

        duplicatesMap = animalList.stream()
                .collect(Collectors.groupingBy(animal -> animal.getClass().getSimpleName()));

        return duplicatesMap;
    }

    @Override
    public Double findAverageAge(List<Animal> animalList) {
        return animalList.stream()
                .mapToInt(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears())
                .average()
                .orElse(0);
    }

    @Override
    public List<Animal> findOldAndExpensive(List<Animal> animalList) {
        var averageCost = animalList.stream()
                .mapToDouble(Animal::getCost)
                .average()
                .orElse(0);

        List<Animal> findOldAndExpensive = animalList.stream()
                .filter(animal -> animal.getCost() > averageCost && Period.between(animal.getBirthDate(), LocalDate.now()).getYears() > 5)
                .sorted(Comparator.comparingInt(animal -> animal.getBirthDate().getYear()))
                .toList();

        return findOldAndExpensive;
    }

    @Override
    public List<String> findMinConstAnimal(List<Animal> animalList) {
        return animalList.stream()
                .sorted(Comparator.comparingDouble(Animal::getCost).reversed())
                .limit(3)
                .sorted(Comparator.comparing(Animal::getName).reversed())
                .map(Animal::getName)
                .toList();
    }
}
