package mts.homework.sivelkaev.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import mts.homework.sivelkaev.controller.dto.response.AnimalDtoResponse;
import mts.homework.sivelkaev.controller.dto.response.FindOlderAnimalResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Validated
@RequestMapping(value = "mts-homework-sivelkaev", produces = MediaType.APPLICATION_JSON_VALUE)
public interface AnimalController {
    @GetMapping(value = "animals/{id}")
    @Parameter(name = "id", in = ParameterIn.PATH, schema = @Schema(type = "string"), required = true)
    ResponseEntity<AnimalDtoResponse> getAnimal(@PathVariable(value = "id") @NotNull String id);

    @PutMapping(value = "animal/{type}")
    @Parameter(name = "type", in = ParameterIn.PATH, schema = @Schema(type = "string"), required = true)
    ResponseEntity<AnimalDtoResponse> createAnimal(@PathVariable(value = "type") @NotNull String type);

    @GetMapping(value = "animal/olderAnimal")
    @Parameter(name = "age", in = ParameterIn.QUERY, required = true)
    ResponseEntity<FindOlderAnimalResponse> findOlderAnimal(@RequestParam(value = "age") Integer age);

}
