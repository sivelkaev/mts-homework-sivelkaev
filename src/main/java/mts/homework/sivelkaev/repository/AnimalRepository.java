package mts.homework.sivelkaev.repository;

import mts.homework.starter.animal.Animal;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearNames(List<Animal> animalList) throws InvalidAnimalBirthDateException;

    Map<Animal, Integer> findOlderAnimal(List<Animal> animalList, Integer age);

    Map<String, List<Animal>> findDuplicate(List<Animal> animalList);

    Double findAverageAge(List<Animal> animalList);

    List<Animal> findOldAndExpensive(List<Animal> animalList);

    List<String> findMinConstAnimal(List<Animal> animalList);
}
