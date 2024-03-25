package mts.homework.sivelkaev.service;

import mts.homework.sivelkaev.animal.Animal;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;

public interface SearchService {
    Boolean checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException;
}
