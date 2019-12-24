package me.jeancsil.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRunner extends Thread {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyRunner(final String threadName) {
        setName(threadName);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            logger.info("({})\t{}\tlooping ...", getName(), i);
        }
    }
}
