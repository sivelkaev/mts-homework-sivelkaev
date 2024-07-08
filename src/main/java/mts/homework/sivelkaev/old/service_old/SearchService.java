package mts.homework.sivelkaev.old.service_old;

import mts.homework.starter.animal.Animal;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;

public interface SearchService {
    Boolean checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException;
}
