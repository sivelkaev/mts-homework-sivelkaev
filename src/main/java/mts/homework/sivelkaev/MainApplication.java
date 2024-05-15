package mts.homework.sivelkaev;

import mts.homework.sivelkaev.animal.predator.species.Wolf;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;
import mts.homework.sivelkaev.exception.InvalidAnimalException;
import mts.homework.sivelkaev.repository.impl.AnimalRepositoryImpl;
import mts.homework.sivelkaev.service.impl.CreateAnimalServiceImpl;
import mts.homework.sivelkaev.service.impl.SearchServiceImpl;
import mts.homework.sivelkaev.thread.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainApplication {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        SearchServiceImpl searchServiceImpl = new SearchServiceImpl();
        AnimalRepositoryImpl animalRepositoryImpl = new AnimalRepositoryImpl();

        var animalMap = createAnimalServiceImpl.createAnimalGroup();
        System.out.println("\n");

        createAnimalServiceImpl.createOtherAnimalGroup();
        System.out.println("\n");

        createAnimalServiceImpl.createOtherAnimalGroup(new Random().nextInt(1, 10));
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

        // Многопоточность. 2 задача
        Counter counter = new Counter();
        Thread thread1 = new CountThread(counter);
        Thread thread2 = new CountThread(counter);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCount()); // всегда 200

        // Многопоточность. 6 задача
        long startTime = System.currentTimeMillis();
        new RandomGenerator(5555).run();
        long oneThreadTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        Thread thread3 = new Thread(() -> new RandomGenerator(1111).run());
        Thread thread4 = new Thread(() -> new RandomGenerator(4444).run());
        thread3.start();
        thread4.start();

        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long twoThreadTime = System.currentTimeMillis() - startTime;

        System.out.println(twoThreadTime < oneThreadTime ? "Два потока были быстрее" : "Один поток был быстрее");

        // Многопоточность. 8 задача
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> result1 = executor.submit(new Fibonacci(1, 4));
        Future<Integer> result2 = executor.submit(new Fibonacci(5, 8));
        int result = result1.get()+result2.get();
        System.out.println("Сумма первых 8 чисел Фиббоначи равна " + result);
        executor.shutdown();
    }
}
