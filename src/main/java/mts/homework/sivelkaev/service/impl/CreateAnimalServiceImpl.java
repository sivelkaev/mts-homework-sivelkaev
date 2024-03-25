package mts.homework.sivelkaev.service.impl;

import mts.homework.sivelkaev.service.CreateAnimalService;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public void createAnimalGroup() {
        int i = 0;
        do {
            createAnimal();
            i++;

        }
        while (i < 11);
    }

    public void createOtherAnimalGroup() {
        for(int i = 0; i < 10; i++) {
            createAnimal();
        }
    }

    public void createOtherAnimalGroup(int n) {
        for(int i = 0; i < n; i++) {
            createAnimal();
        }
    }
}
