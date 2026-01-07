package com.ankitmahala07.benchmark_vtvscf.benchmark;

public class IOSimulation {
    public static String ioTask(int id) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "task-" + id;
    }
}
