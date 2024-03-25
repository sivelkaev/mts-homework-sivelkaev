package mts.homework.sivelkaev.repository.impl;

import mts.homework.sivelkaev.animal.Animal;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;
import mts.homework.sivelkaev.repository.AnimalRepository;
import mts.homework.sivelkaev.service.impl.SearchServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class AnimalRepositoryImpl implements AnimalRepository {
    SearchServiceImpl searchService = new SearchServiceImpl();

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animalList) throws InvalidAnimalBirthDateException {
        Map<String, LocalDate> datesMap = new HashMap<>();

        for(Animal animal : animalList) {
            if(searchService.checkLeapYearAnimal(animal)) {
                datesMap.put(animal.getClass().getSimpleName() + " " + animal.getName(), animal.getBirthDate());
            }
        }


        return datesMap;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animalList, Integer age) {
        Map<Animal, Integer> agesMap = new HashMap<>();
        Animal oldestAnimal = null;

        for(Animal animal : animalList) {
            var animalAge = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
            if(animalAge >= age) {
                agesMap.put(animal, animalAge);
            }
            if(oldestAnimal == null || animal.getBirthDate().isBefore(oldestAnimal.getBirthDate())) {
                oldestAnimal = animal;
            }

        }

        if(agesMap.size() == 0) {
            agesMap.put(oldestAnimal, Period.between(oldestAnimal.getBirthDate(), LocalDate.now()).getYears());
        }

        return agesMap;
    }

    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animalList) {
        Map<String, Integer> duplicatesMap = new HashMap<>();
        Set<Animal> alreadyDuplicatedAnimal = new HashSet<>();

        for (int i = 0; i < animalList.size(); i++) {
            for (int j = 0; j < animalList.size(); j++) {
                if (i != j
                        && animalList.get(i).getClass().getSimpleName().equals(animalList.get(j).getClass().getSimpleName())
                        && animalList.get(i).getName().equals(animalList.get(j).getName())
                        && alreadyDuplicatedAnimal.add(animalList.get(j))) {
                    if(duplicatesMap.containsKey(animalList.get(i).getClass().getSimpleName())) {
                        int count = duplicatesMap.get(animalList.get(i).getClass().getSimpleName());
                        duplicatesMap.put(animalList.get(i).getClass().getSimpleName(), count + 1);
                    } else {
                        duplicatesMap.put(animalList.get(i).getClass().getSimpleName(), 1);
                    }
                }
            }
        }

        return duplicatesMap;
    }
}
