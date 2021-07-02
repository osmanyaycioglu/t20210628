package com.training.javaee.jms;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class JavaQueueRun {

    BlockingQueue<String> queueLoc = new ArrayBlockingQueue<>(1000);

    public static void main(final String[] args) {
        JavaQueueRun javaQueueRunLoc = new JavaQueueRun();
        for (int iLoc = 0; iLoc < 10; iLoc++) {
            javaQueueRunLoc.queueLoc.add("test" + iLoc);
        }

        for (int iLoc = 0; iLoc < 2; iLoc++) {
            Thread threadLoc = new Thread(() -> {
                while (true) {
                    try {
                        String takeLoc = javaQueueRunLoc.queueLoc.take();
                        System.out.println("Thread : "
                                           + Thread.currentThread()
                                                   .getName()
                                           + " data : "
                                           + takeLoc);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            threadLoc.setName("QueueReader-" + iLoc);
            threadLoc.start();
        }
        for (int iLoc = 0; iLoc < 100; iLoc++) {
            try {
                Thread.sleep(1_000);
                javaQueueRunLoc.queueLoc.add("extra " + iLoc);
            } catch (Exception eLoc) {
            }
        }

    }
}
