package mts.homework.sivelkaev.service;

import com.google.gson.*;
import mts.homework.starter.animal.Animal;
import mts.homework.starter.animal.pet.species.Dog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class ResultReader {
    public Animal getJsonContent() {
        String jsonString = getFileContent("C:\\Users\\gasivelkay\\Documents\\GitHub\\mts-homework-sivelkaev\\src\\main\\resources\\results\\findOlderAnimal.json");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .create();
        Animal animal = gson.fromJson(jsonString, Dog.class);

        animal.setSecretInformation(base64ToString(animal.getSecretInformation()));

        return animal;
    }

    public int calculateNumberOfLines() {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\gasivelkay\\Documents\\GitHub\\mts-homework-sivelkaev\\src\\main\\resources\\logData.txt"))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
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

    private String base64ToString(String base64) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        return new String(decodedBytes);
    }

    private static class LocalDateSerializer implements JsonSerializer<LocalDate> {
        @Override
        public JsonElement serialize(LocalDate localDate, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }

    private static class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) {
            return LocalDate.parse(jsonElement.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }
}
