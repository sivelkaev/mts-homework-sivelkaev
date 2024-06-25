package mts.homework.sivelkaev.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mts.homework.sivelkaev.controller.AnimalController;
import mts.homework.sivelkaev.controller.dto.response.AnimalDtoResponse;
import mts.homework.sivelkaev.controller.dto.response.FindOlderAnimalResponse;
import mts.homework.sivelkaev.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AnimalControllerImpl implements AnimalController {
    private final AnimalService animalService;

    @Override
    public ResponseEntity<AnimalDtoResponse> getAnimal(String id) {
        return ResponseEntity.ok(animalService.getAnimal(Long.valueOf(id)));
    }

    @Override
    public ResponseEntity<AnimalDtoResponse> createAnimal(String type) {
        return ResponseEntity.ok(animalService.createAnimal(type));
    }

    @Override
    public ResponseEntity<FindOlderAnimalResponse> findOlderAnimal(Integer age) {
        return ResponseEntity.ok(animalService.findOlderAnimal(age));
    }
}
