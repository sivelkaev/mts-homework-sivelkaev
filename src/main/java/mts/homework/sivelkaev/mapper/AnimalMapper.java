package mts.homework.sivelkaev.mapper;

import mts.homework.sivelkaev.controller.dto.response.AnimalDtoResponse;
import mts.homework.sivelkaev.model.entity.AnimalEntity;
import mts.homework.sivelkaev.model.entity.AnimalTypeEntity;
import mts.homework.starter.animal.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AnimalMapper {
    @Mapping(target = "type", expression = "java(entity.getType().getType())")
    @Mapping(target = "breed", source = "entity.breed")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "cost", source = "entity.cost")
    @Mapping(target = "character", source = "entity.character")
    @Mapping(target = "birthDate", source = "entity.birthDate")
    AnimalDtoResponse mapToDto(AnimalEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", source = "animalTypeEntity")
    @Mapping(target = "breed", source = "animal.breed")
    @Mapping(target = "name", source = "animal.name")
    @Mapping(target = "cost", source = "animal.cost")
    @Mapping(target = "character", source = "animal.character")
    @Mapping(target = "birthDate", source = "animal.birthDate")
    AnimalEntity mapToEntity(Animal animal, AnimalTypeEntity animalTypeEntity);
}
