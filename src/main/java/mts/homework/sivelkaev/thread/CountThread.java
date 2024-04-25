package mts.homework.sivelkaev.thread;

public class CountThread extends Thread {
    private Counter count;

    public CountThread(Counter count) {
        this.count = count;
    }

    @Override
    public void run () {
        int i = 0;
        while (i < 100) {
            count.increment();
            i++;
        }
    }
}
