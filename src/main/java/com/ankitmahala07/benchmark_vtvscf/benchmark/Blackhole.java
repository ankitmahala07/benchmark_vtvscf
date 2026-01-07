package com.ankitmahala07.benchmark_vtvscf.benchmark;

public final class Blackhole {
    private static volatile long sink;

    public static void consume(long value) {
        sink ^= value;
    }
}
