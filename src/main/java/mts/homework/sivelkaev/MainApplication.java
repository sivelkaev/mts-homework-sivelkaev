package mts.homework.sivelkaev;

import mts.homework.sivelkaev.service.impl.CreateAnimalServiceImpl;

import java.util.Random;

public class MainApplication {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();

        createAnimalServiceImpl.createAnimalGroup();
        System.out.println("\n");
        createAnimalServiceImpl.createOtherAnimalGroup();
        System.out.println("\n");
        createAnimalServiceImpl.createOtherAnimalGroup(new Random().nextInt(1,10));
    }
}
