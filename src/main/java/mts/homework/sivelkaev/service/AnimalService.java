package mts.homework.sivelkaev.service;

import mts.homework.sivelkaev.controller.dto.response.AnimalDtoResponse;
import mts.homework.sivelkaev.controller.dto.response.FindOlderAnimalResponse;

public interface AnimalService {
    /**
     * @param id - идентификатор животного
     *
     * @return Возвращает животного
     */
    AnimalDtoResponse getAnimal(Long id);

    /**
     * @param type - тип животного
     *
     * @return Возвращает животного
     */
    AnimalDtoResponse createAnimal(String type);

    /**
     * @param age - возраст
     *
     * @return Возвращает животного
     */
    FindOlderAnimalResponse findOlderAnimal(Integer age);
}
