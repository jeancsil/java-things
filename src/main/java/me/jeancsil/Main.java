package me.jeancsil;

import me.jeancsil.threads.MyRunner;
import me.jeancsil.threads.MyRunnerWithSleep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var start = Instant.now();
        var threadsToCreate = 10;

        ExecutorService executor = Executors.newFixedThreadPool(threadsToCreate);
        for (int i = 1; i <= threadsToCreate; i++) {
            executor.submit(new MyRunner("Thread #" + i));
            executor.submit(new MyRunnerWithSleep("Thread #" + i));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
            var finished = executor.isTerminated() ? "Finished" : "Didn't Finish";
            logger.info("[ThreadPool] {} in {}ms", finished, Duration.between(start, Instant.now()).toMillis());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
