package com.ankitmahala07.benchmark_vtvscf.benchmark;

public class BenchmarkRunner {
    public static void run(String name, Runnable task) {
        System.out.println("Starting: " + name);

        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();

        long durationMs = (end - start) / 1_000_000;
        System.out.println(name + " completed in " + durationMs + " ms");
        System.out.println();
    }
}
