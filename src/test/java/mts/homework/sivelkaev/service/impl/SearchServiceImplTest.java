package mts.homework.sivelkaev.service.impl;

import mts.homework.starter.animal.Animal;
import mts.homework.starter.animal.predator.species.Wolf;
import mts.homework.sivelkaev.exception.InvalidAnimalBirthDateException;
import mts.homework.sivelkaev.exception.InvalidAnimalException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SearchServiceImplTest {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @InjectMocks
    private SearchServiceImpl searchService;

    @Test
    @DisplayName("Високосный год")
    public void checkLeapYearAnimal_success_leapYear() {
        Animal animal = new Wolf("wolfBreed", "wolfName", 1.23, "wolfCharacter", LocalDate.of(2004, 02, 02));
        Boolean result;
        try {
            result = searchService.checkLeapYearAnimal(animal);
            assertTrue(result);
        } catch (Exception e) {
            System.out.println("OOOPS!");
        }
    }

    @Test
    @DisplayName("Не високосный год")
    public void checkLeapYearAnimal_success_nonLeapYear() {
        Animal animal = new Wolf("wolfBreed", "wolfName", 1.23, "wolfCharacter", LocalDate.of(2003, 02, 02));
        Boolean result;
        try {
            result = searchService.checkLeapYearAnimal(animal);
            assertFalse(result);
        } catch (Exception e) {
            System.out.println("OOOPS!");
        }
    }

    @Test
    @DisplayName("Пустая дата рождения")
    public void checkLeapYearAnimal_exception_emptyBirthDate() {
        Animal animal = new Wolf("wolfBreed", "wolfName", 1.23, "wolfCharacter", null);

        var ex = assertThrows(InvalidAnimalBirthDateException.class,
                () -> searchService.checkLeapYearAnimal(animal));

        assertEquals("У животного wolfBreed не указана дата рождения", ex.getMessage());
    }

    @Test
    @DisplayName("Пустой объект")
    public void checkLeapYearAnimal_exception_emptyAnimal() {
        var ex = assertThrows(InvalidAnimalException.class,
                () -> searchService.checkLeapYearAnimal(null));

        assertEquals("На вход пришел некорректный объект животного - " + LocalDate.now().format(formatter), ex.getMessage());
    }
}
