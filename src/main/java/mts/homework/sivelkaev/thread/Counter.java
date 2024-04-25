package mts.homework.sivelkaev.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count;

    public Counter() {
        count = new AtomicInteger(0);
    }

    public int getCount() {
        return count.get();
    }

    public void increment() {
        count.incrementAndGet();
    }
}
