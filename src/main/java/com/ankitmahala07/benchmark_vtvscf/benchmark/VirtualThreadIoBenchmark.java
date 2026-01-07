package com.ankitmahala07.benchmark_vtvscf.benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadIoBenchmark {
    public static void run() {
        int taskCount = 500;

        ExecutorService executor =
                Executors.newVirtualThreadPerTaskExecutor();

        BenchmarkRunner.run("VirtualThread IO", () -> {
            List<Future<?>> futures = new ArrayList<>();

            for (int i = 0; i < taskCount; i++) {
                int id = i;
                futures.add(
                        executor.submit(
                                () -> IOSimulation.ioTask(id)
                        )
                );
            }

            futures.forEach(f -> {
                try {
                    f.get();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        });

        executor.shutdown();
    }
}
