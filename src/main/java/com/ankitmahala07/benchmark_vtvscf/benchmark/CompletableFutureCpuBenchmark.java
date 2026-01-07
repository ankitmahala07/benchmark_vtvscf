package com.ankitmahala07.benchmark_vtvscf.benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureCpuBenchmark {
    public static void run() {
        int taskCount = 500;

        ExecutorService executor =
                Executors.newFixedThreadPool(
                        Runtime.getRuntime().availableProcessors()
                );

        BenchmarkRunner.run("CompletableFuture CPU", () -> {
            List<CompletableFuture<Long>> futures = new ArrayList<>();

            for (int i = 0; i < taskCount; i++) {
                int id = i;
                futures.add(
                        CompletableFuture.supplyAsync(
                                () -> CPUSimulation.cpuTask(id),
                                executor
                        )
                );
            }

            futures.forEach(CompletableFuture::join);
        });

        executor.shutdown();

    }
}
