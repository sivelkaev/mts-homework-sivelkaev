package mts.homework.sivelkaev;

import mts.homework.sivelkaev.animal.predator.species.Wolf;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;
import mts.homework.sivelkaev.exception.InvalidAnimalException;
import mts.homework.sivelkaev.repository.impl.AnimalRepositoryImpl;
import mts.homework.sivelkaev.service.impl.CreateAnimalServiceImpl;
import mts.homework.sivelkaev.service.impl.SearchServiceImpl;

import java.time.LocalDate;
import java.util.Random;

public class MainApplication {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        SearchServiceImpl searchServiceImpl = new SearchServiceImpl();
        AnimalRepositoryImpl animalRepositoryImpl = new AnimalRepositoryImpl();

        var animalMap = createAnimalServiceImpl.createAnimalGroup();
        System.out.println("\n");

        createAnimalServiceImpl.createOtherAnimalGroup();
        System.out.println("\n");

        createAnimalServiceImpl.createOtherAnimalGroup(new Random().nextInt(1,10));
        System.out.println("\n");

        try {
            //Високосный
            Wolf wolf1 = new Wolf("wolfBreed", "wolfName", new Random().nextDouble(), "wolfCharacter", LocalDate.of(2024, 02, 02));
            System.out.println(searchServiceImpl.checkLeapYearAnimal(wolf1) ? wolf1.getName() + " был рожден в високосный год" : wolf1.getName() + " не был рожден в високосный год");

            //Невисокосный
            Wolf wolf2 = new Wolf("wolfBreed", "wolfName", new Random().nextDouble(), "wolfCharacter", LocalDate.of(2023, 02, 02));
            System.out.println(searchServiceImpl.checkLeapYearAnimal(wolf2) ? wolf2.getName() + " был рожден в високосный год" : wolf2.getName() + " не был рожден в високосный год");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            //Пустая дата
            searchServiceImpl.checkLeapYearAnimal(new Wolf("wolfBreed", "wolfName", new Random().nextDouble(), "wolfCharacter", null));
        } catch (InvalidAnimalException | InvalidAnimalBirthDateException e) {
           System.err.println("Работа метода завершилась ошибкой: " + e.getMessage());
        }

        try {
            //Пустой объект
            searchServiceImpl.checkLeapYearAnimal(null);
        } catch (InvalidAnimalException | InvalidAnimalBirthDateException e) {
            System.err.println("Работа метода завершилась ошибкой: " + e.getMessage());
        }

        try {
            //Метод findLeapYearNames
            System.out.println(animalRepositoryImpl.findLeapYearNames(animalMap.get("Dog")));

            //Метод findOlderAnimal
            System.out.println(animalRepositoryImpl.findOlderAnimal(animalMap.get("Dog"), 9999999));

            //Метод findLeapYearNames
            System.out.println(animalRepositoryImpl.findDuplicate(animalMap.get("Dog")));

            //Метод findAverageAge
            System.out.println(animalRepositoryImpl.findAverageAge(animalMap.get("Dog")));

            //Метод findOldAndExpensive
            System.out.println(animalRepositoryImpl.findOldAndExpensive(animalMap.get("Dog")));

            //Метод findMinConstAnimal
            System.out.println(animalRepositoryImpl.findMinConstAnimal(animalMap.get("Dog")));
        } catch (InvalidAnimalException | InvalidAnimalBirthDateException e) {
            System.err.println("Работа метода завершилась ошибкой: " + e.getMessage());
        }
    }
}
