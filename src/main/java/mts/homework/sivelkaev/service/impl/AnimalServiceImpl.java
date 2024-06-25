package mts.homework.sivelkaev.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mts.homework.sivelkaev.controller.dto.response.AnimalDtoResponse;
import mts.homework.sivelkaev.controller.dto.response.FindOlderAnimalResponse;
import mts.homework.sivelkaev.mapper.AnimalMapper;
import mts.homework.sivelkaev.model.entity.AnimalEntity;
import mts.homework.sivelkaev.model.repository.AnimalRepository;
import mts.homework.sivelkaev.model.repository.AnimalTypeRepository;
import mts.homework.sivelkaev.service.AnimalService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalTypeRepository animalTypeRepository;
    private final mts.homework.starter.service.AnimalService starterAnimalService;
    private final AnimalMapper animalMapper;

    @Override
    public AnimalDtoResponse getAnimal(Long id) {
        var animal = animalRepository.findById(id);

        if (animal.isEmpty()) {
            return new AnimalDtoResponse();
        }

        return animalMapper.mapToDto(animal.get());
    }

    @Override
    public AnimalDtoResponse createAnimal(String type) {
        var animalType = animalTypeRepository.findByType(type);

        if (animalType.isEmpty()) {
            return new AnimalDtoResponse();
        }

        var starterAnimal = starterAnimalService.createAnimal();

        var animal = animalMapper.mapToEntity(starterAnimal, animalType.get());
        animalRepository.save(animal);

        return animalMapper.mapToDto(animal);
    }

    @Override
    public FindOlderAnimalResponse findOlderAnimal(Integer age) {
        List<FindOlderAnimalResponse.AnimalParam> ages;

        var animals = animalRepository.findAll();

        ages = animals.stream()
                .anyMatch(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears() >= age)
                ? animals.stream()
                    .filter(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears() >= age)
                    .map(animal -> FindOlderAnimalResponse.AnimalParam.builder().animal(animalMapper.mapToDto(animal)).age(Period.between(animal.getBirthDate(), LocalDate.now()).getYears()).build())
                    .toList()
                : animals.stream()
                    .min(Comparator.comparing(AnimalEntity::getBirthDate))
                    .stream()
                    .map(animal -> FindOlderAnimalResponse.AnimalParam.builder().animal(animalMapper.mapToDto(animal)).age(Period.between(animal.getBirthDate(), LocalDate.now()).getYears()).build())
                    .toList();
        return new FindOlderAnimalResponse(ages);
    }
}
