package mts.homework.sivelkaev.old.thread;

import java.util.concurrent.Callable;

public class Fibonacci implements Callable<Integer> {
    private int n;
    private int m;

    public Fibonacci(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public Integer call() {
        return fibonacci(n, m);
    }

    private int fibonacci(int n, int m) {
        int result = 0;
        int fib1 = 0;
        int fib2 = 1;

        for (int i = 1; i <= m; i++) {
            if (i >= n) {
                result += fib1;
            }
            int nextFib = fib1 + fib2;
            fib1 = fib2;
            fib2 = nextFib;
        }

        return result;
    }
}
