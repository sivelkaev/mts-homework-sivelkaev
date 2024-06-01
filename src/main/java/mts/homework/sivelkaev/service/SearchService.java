package mts.homework.sivelkaev.service;

import mts.homework.starter.animal.Animal;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;

public interface SearchService {
    Boolean checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException;
}
