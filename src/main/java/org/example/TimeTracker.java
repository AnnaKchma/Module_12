package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeTracker {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new TimeTask(), 0, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new SecondFlowTask(), 0, 5, TimeUnit.SECONDS);
    }
}

class TimeTask implements Runnable {
    private long startTime = System.currentTimeMillis();

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        long elapsedMillis = currentTime - startTime;

        System.out.printf("Time passed: %.2f seconds%n", elapsedMillis / 1000.0);
    }
}

class SecondFlowTask implements Runnable {
    private long previousTime = System.currentTimeMillis();

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        long elapsedMillis = currentTime - previousTime;

        if (elapsedMillis >= 5000) {
            System.out.println("5 seconds passed");
            previousTime = currentTime;
        }
    }
}