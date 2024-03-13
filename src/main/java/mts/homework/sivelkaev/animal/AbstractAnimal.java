package mts.homework.sivelkaev.animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractAnimal implements Animal {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;
    protected LocalDate birthDate;

    public AbstractAnimal(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getCost() {
        return this.cost;
    }

    @Override
    public String getCharacter() {
        return this.character;
    }

    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void printInfo() {
        System.out.println("Breed - " + this.breed + ", Name - " + this.name + ", Cost - " + this.cost + ", Character - " + this.character + ", Birth Date - " + this.birthDate.format(formatter));
    }
}
