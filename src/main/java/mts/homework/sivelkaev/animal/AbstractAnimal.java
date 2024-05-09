package mts.homework.sivelkaev.animal;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;
    protected LocalDate birthDate;
    protected String secretInformation;

    public AbstractAnimal(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
        String FILE_PATH = "C:\\Users\\gasivelkay\\Documents\\GitHub\\mts-homework-sivelkaev\\src\\main\\resources\\secretStore\\secretInformation.txt";
        this.secretInformation = getFileContent(FILE_PATH);
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

    @Override
    public String getSecretInformation() {
        return this.secretInformation;
    }

    @Override
    public void setSecretInformation(String secretInformation) { this.secretInformation = secretInformation; }

    @Override
    public void printInfo() {
        System.out.println("Breed - " + this.breed + ", Name - " + this.name + ", Cost - " + this.cost + ", Character - " + this.character + ", Birth Date - " + this.birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " + this.secretInformation);
    }

    private String getFileContent(String filePath) {
        StringBuilder content = new StringBuilder();

        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append(" ");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    private String toBase64(String text) {
        byte[] encodedBytes = Base64.encodeBase64(text.getBytes());
        return new String(encodedBytes);
    }
}
