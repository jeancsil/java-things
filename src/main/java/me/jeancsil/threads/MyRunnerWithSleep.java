package me.jeancsil.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRunnerWithSleep extends Thread {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyRunnerWithSleep(final String threadName) {
        setName(threadName);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            logger.info("({})\t{}\tlooping w/ sleep ...", getName(), i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                logger.warn("Caught the InterruptedException...");
                break;
            }
        }
    }
}
