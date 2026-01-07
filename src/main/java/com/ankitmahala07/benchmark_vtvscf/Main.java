package com.ankitmahala07.benchmark_vtvscf;

import com.ankitmahala07.benchmark_vtvscf.benchmark.CompletableFutureCpuBenchmark;
import com.ankitmahala07.benchmark_vtvscf.benchmark.CompletableFutureIoBenchmark;
import com.ankitmahala07.benchmark_vtvscf.benchmark.VirtualThreadCpuBenchmark;
import com.ankitmahala07.benchmark_vtvscf.benchmark.VirtualThreadIoBenchmark;

public class Main {
    public static void main(String[] args) {
        // JVM warm-up run (ignore results)
        System.out.println("======== WARM UP RESULTS (IGNORE) ========");

        CompletableFutureIoBenchmark.run();
        VirtualThreadIoBenchmark.run();
        CompletableFutureCpuBenchmark.run();
        VirtualThreadCpuBenchmark.run();

        // Real benchmark run
        System.out.println("======== REAL RUN ========");

        CompletableFutureIoBenchmark.run();
        VirtualThreadIoBenchmark.run();
        CompletableFutureCpuBenchmark.run();
        VirtualThreadCpuBenchmark.run();
    }
}
