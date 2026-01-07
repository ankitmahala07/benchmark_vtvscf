package com.ankitmahala07.benchmark_vtvscf.benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureIoBenchmark {
    public static void run() {
        int taskCount = 500;

        ExecutorService executor =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<CompletableFuture<String>> futures = new ArrayList<>();

        BenchmarkRunner.run("CompletableFuture IO", () -> {
            for (int i = 0; i < taskCount; i++) {
                int id = i;
                futures.add(
                        CompletableFuture.supplyAsync(
                                () -> IOSimulation.ioTask(id),
                                executor
                        )
                );
            }

            futures.forEach(CompletableFuture::join);
        });

        executor.shutdown();
    }
}
