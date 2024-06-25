package mts.homework.sivelkaev.old.repository_old.impl;

import mts.homework.sivelkaev.old.repository_old.impl.AnimalRepositoryImpl;
import mts.homework.starter.animal.Animal;
import mts.homework.starter.animal.predator.species.Wolf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnimalRepositoryImplTest {
    @InjectMocks
    private AnimalRepositoryImpl animalRepository;

    @Test
    @DisplayName("Самое старое животное - массив старших")
    public void findOlderAnimal_several() {
        Animal wolf1 = new Wolf("wolfBreed", "wolfName", 1.23, "wolfCharacter", LocalDate.of(2004, 02, 02));
        Animal wolf2 = new Wolf("wolfBreed", "wolfName", 1.23, "wolfCharacter", LocalDate.of(2005, 02, 02));
        Animal wolf3 = new Wolf("wolfBreed", "wolfName", 1.23, "wolfCharacter", LocalDate.of(2019, 02, 02));
        var animalList = List.of(wolf1, wolf2, wolf3);

        var animalMap = animalRepository.findOlderAnimal(animalList, 10);

        assertEquals(2, animalMap.size());
        assertEquals(20, animalMap.get(wolf1));
        assertEquals(19, animalMap.get(wolf2));
    }

    @Test
    @DisplayName("Самое старое животное - самый старший")
    public void findOlderAnimal_one() {
        Animal wolf1 = new Wolf("wolfBreed", "wolfName", 1.23, "wolfCharacter", LocalDate.of(2004, 02, 02));
        Animal wolf2 = new Wolf("wolfBreed", "wolfName", 1.23, "wolfCharacter", LocalDate.of(2005, 02, 02));
        Animal wolf3 = new Wolf("wolfBreed", "wolfName", 1.23, "wolfCharacter", LocalDate.of(2019, 02, 02));
        var animalList = List.of(wolf1, wolf2, wolf3);

        var animalMap = animalRepository.findOlderAnimal(animalList, 30);

        assertEquals(1, animalMap.size());
        assertEquals(20, animalMap.get(wolf1));
    }
}
