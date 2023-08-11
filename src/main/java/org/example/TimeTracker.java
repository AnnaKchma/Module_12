package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeTracker {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new TimeTask(), 0, 1, TimeUnit.SECONDS);
    }
}

class TimeTask implements Runnable {
    private final long startTime = System.currentTimeMillis();

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        long elapsedMillis = currentTime - startTime;

        System.out.printf("Time passed: %.2f seconds%n", elapsedMillis / 1000.0);

        if (elapsedMillis % 5000 == 0) {
            System.out.println("5 seconds passed");
        }
    }
}