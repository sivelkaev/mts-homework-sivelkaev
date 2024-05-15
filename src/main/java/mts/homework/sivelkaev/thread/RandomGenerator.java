package mts.homework.sivelkaev.thread;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class RandomGenerator {
    private int numberOfRandoms;

    public void run() {
        Random random = new Random();

        for (int i = 0; i < numberOfRandoms; i++) {
            random.nextInt();
        }
    }
}
