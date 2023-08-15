package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FizzBuzzMultithreaded {
    private final int n;
    private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    public void fizz() throws InterruptedException {
        // Your implementation for fizz
    }

    public void buzz() throws InterruptedException {
        // Your implementation for buzz
    }

    public void fizzbuzz() throws InterruptedException {
        // Your implementation for fizzbuzz
    }

    public void fizzbuzzNumber() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                queue.put("fizzbuzz");
            } else if (i % 3 == 0) {
                queue.put("fizz");
            } else if (i % 5 == 0) {
                queue.put("buzz");
            } else {
                queue.put(Integer.toString(i));
            }
            System.out.println(queue.take());
        }
    }
}