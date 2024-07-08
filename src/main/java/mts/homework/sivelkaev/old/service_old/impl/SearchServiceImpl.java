package mts.homework.sivelkaev.old.service_old.impl;

import mts.homework.starter.animal.Animal;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;
import mts.homework.sivelkaev.exception.InvalidAnimalException;
import mts.homework.sivelkaev.old.service_old.SearchService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class SearchServiceImpl implements SearchService {
    public Boolean checkLeapYearAnimal(Animal animal) throws InvalidAnimalException, InvalidAnimalBirthDateException {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        if(animal == null) {
            throw new InvalidAnimalException("На вход пришел некорректный объект животного - " + LocalDate.now().format(formatter));
        }

        if(animal.getBirthDate() == null) {
            throw new InvalidAnimalBirthDateException("У животного " + animal.getBreed() + " не указана дата рождения");
        }

        return animal.getBirthDate().isLeapYear();
    }
}
